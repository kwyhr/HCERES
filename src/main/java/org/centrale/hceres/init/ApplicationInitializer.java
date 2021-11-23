/* --------------------------------------------------------------------------------
 * Projet HCERES
 * 
 * Gestion de données pour l'HCERES
 * 
 * Ecole Centrale Nantes - laboratoire CRTI
 * Avril 2021
 * L LETERTRE, S LIMOUX, JY MARTIN
 * -------------------------------------------------------------------------------- */
package org.centrale.hceres.init;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.centrale.hceres.items.Parameter;
import org.centrale.hceres.items.Status;
import org.centrale.ldap.LDAPManager;
import org.springframework.stereotype.Controller;

/**
 * Application initializer
 *
 * @author kwyhr
 */
@Controller
public class ApplicationInitializer implements ServletContextListener {

    private static final String PUNAME = "org.centrale.hceres_HCERES_war_1.0PU";
    private static EntityManager em;

    // Data from persistance unit
    private static String dbUser;
    private static String dbPass;
    private static String dbURL;
    private static String dbDriver;
    private static ServletContext servletContext;

    /**
     *
     * @param event
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        servletContext = event.getServletContext();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PUNAME);
        Cache theCache = emf.getCache();
        theCache.evictAll();
        em = emf.createEntityManager();
        try {
            // Get data
            Map<String, Object> properties = em.getProperties();
            dbUser = (String) properties.get("javax.persistence.jdbc.user");
            dbPass = (String) properties.get("javax.persistence.jdbc.password");
            dbURL = (String) properties.get("javax.persistence.jdbc.url");
            dbDriver = (String) properties.get("javax.persistence.jdbc.driver");
        } catch (Exception ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.INFO, null, ex);
        }
        
        // Initialize data
        initLDAP();
        createDefault();

        // close
        em.close();
        emf.close();
    }

    /**
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * Get parameter from table Parameter
     *
     * @param name
     * @return
     */
    private static String getParameter(String name) {
        String returnedValue = null;
        try {
            Query theQuery = em.createNamedQuery("Parameter.findByParameterName", Parameter.class);
            theQuery.setParameter("parameterName", name);
            Parameter parameter = (Parameter) theQuery.getSingleResult();
            if (parameter != null) {
                returnedValue = parameter.getParameterValue();
            }
        } catch (NoResultException ex) {
        }
        return returnedValue;
    }

    /**
     * Initialise LDAP server parameters
     */
    private void initLDAP() {
        String serverName = getParameter("ldapServer");
        String serverDN = getParameter("ldapDN");
        String serverProtocol = getParameter("ldapProtocol");
        if (serverProtocol == null) {
            serverProtocol = "ssl";
        }

        LDAPManager.init(serverName, serverDN, serverProtocol);
    }

    /* ----------------------------------------------------------------------- */
    /**
     * Create default values in Database. This is called once, when application
     * starts
     */
    private void createDefault() {
        createDefaultStatus();

        // First check that we can reload : that means there is a parameter loadCsv in the database
        String loadCSV = getParameter("loadCsv");
        if (loadCSV != null) {
            reloadDataFromFiles();
        }
    }

    /* ----------------------------------------------------------------------- */
    /**
     * Load CSV files
     */
    private void reloadDataFromFiles() {
        List<File> filesToProcess = new ArrayList<File>();

        String fullPath = servletContext.getRealPath("/data");
        loadFileList(filesToProcess, new File(fullPath));
        processFiles(filesToProcess);
    }

    /**
     * Load files in a directory
     *
     * @param filesToProcess
     * @param aFile
     */
    private void loadFileList(List<File> filesToProcess, File aFile) {
        for (final File fileEntry : aFile.listFiles()) {
            if (fileEntry.isDirectory()) {
                loadFileList(filesToProcess, fileEntry);
            } else {
                // Add csv files
                if (fileEntry.getName().endsWith(".csv")) {
                    filesToProcess.add(fileEntry);
                }
            }
        }
    }

    private void resetActivitySequence(Connection connection) {
        try {
            PreparedStatement activityStatement = connection.prepareStatement("SELECT COUNT(*) nb FROM Activity");
            ResultSet actRes = activityStatement.executeQuery();
            actRes.next();
            int nb = actRes.getInt("nb");
            actRes.close();
            if (nb == 0) {
                activityStatement = connection.prepareStatement("ALTER SEQUENCE seq_activity RESTART WITH 1");
                activityStatement.executeUpdate();
                actRes.close();
            } else {
                activityStatement = connection.prepareStatement("SELECT setval('seq_activity', MAX(id_activity), true) FROM Activity");
                activityStatement.executeQuery();
                actRes.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Process_Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Process CSV files
     *
     * @param filesToProcess
     */
    private void processFiles(List<File> filesToProcess) {
        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Reset sequence activity
            resetActivitySequence(connection);
            
            // Loop until all is done, or no file is processed during a turn
            int listSize = -1;
            while ((filesToProcess.size() != listSize) && (!filesToProcess.isEmpty())) {
                listSize = filesToProcess.size();
                List<File> processed = new ArrayList<File>();
                for (File aFile : filesToProcess) {
                    try {
                        loadDataFromFile(aFile, connection);
                        processed.add(aFile);
                    } catch (Exception ex) {
                        // File can't be processed, maybe foreign key problem, should try later
                    }
                }
                for (File aFile : processed) {
                    filesToProcess.remove(aFile);
                }
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Process a file content
     *
     * @param aFile
     * @param connection
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void loadDataFromFile(File aFile, Connection connection) throws Exception {
        Exception savedException = null;

        ApplicationImporter importer = new ApplicationImporter();

        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        CSVReaderBuilder builder = new CSVReaderBuilder(new FileReader(aFile));
        CSVReader csvReader = builder.withCSVParser(parser).build();

        try {
            String[] row = csvReader.readNext();
            String tableName = row[0].trim().toLowerCase();

            // Then data
            // We use code introspevction to check if there is a predefined class for the table
            String tableProcess = (tableName.charAt(0) + "").toUpperCase() + tableName.substring(1);
            String ClassName = "Process_" + tableProcess;
            // Try to get class
            TableImporter tableClass = null;
            try {
                Class myClass = Class.forName(this.getClass().getPackageName() + "." + ClassName);
                tableClass = (TableImporter) myClass.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | ClassNotFoundException ex) {
            }

            if (tableClass != null) {
                // Class exists
                if (tableClass instanceof TableActivityImporter) {
                    ((TableActivityImporter) tableClass).process(csvReader, connection, tableName, tableName);
                } else {
                    tableClass.process(csvReader, connection, tableName);
                }
            } else {
                // Use default call
                importer.parseFile(csvReader, connection, tableName);
            }
        } catch (Exception ex) {
            savedException = ex;
        }
        // Anyway, close file
        csvReader.close();

        // If there was an exception, tell it
        if (savedException != null) {
            throw savedException;
        }
    }

    /* ----------------------------------------------------------------------- */
    private Object getItemFromID(int id, String requestName, Class classType, String fieldName) {
        Object item = null;
        try {
            Query theQuery = em.createNamedQuery(requestName, classType);
            theQuery.setParameter(fieldName, id);
            item = theQuery.getSingleResult();
        } catch (NoResultException ex) {
        }
        return item;
    }

    private Status createStatus(int id, String statusName) {
        Status item = (Status) getItemFromID(id, "Status.findByIdStatus", Status.class, "idStatus");
        if (item == null) {
            // Does not exist
            item = new Status();
            item.setIdStatus(id);
            item.setNameStatus(statusName);
            em.persist(item);
            em.flush();

            // Reload from database to be sure to get it
            item = (Status) getItemFromID(id, "Status.findByIdStatus", Status.class, "idStatus");
        }
        return item;
    }

    private void createDefaultStatus() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        createStatus(1, "Professeurs et assimilés");
        createStatus(2, "Maîtres de conférences et assimilés");
        createStatus(3, "Directeurs de recherche et assimilés");
        createStatus(4, "Chargés de recherche et assimilés");
        createStatus(5, "Conservateurs, cadres scientifiques EPIC, fondations, industries...");
        createStatus(6, "Professeurs du secondaire détachés dans le supérieur");
        createStatus(7, "ITA-BIATSS, autres personnels cadre et non cadre EPIC...");
        createStatus(21, "Enseignants-chercheurs non titulaires, émérites et autres");
        createStatus(22, "Chercheurs non titulaires, émérites et autres (excepté doctorants)");
        createStatus(23, "Doctorants");
        createStatus(24, "Autres personnels non titulaires");
        transaction.commit();
    }
    /* ----------------------------------------------------------------------- */

}
