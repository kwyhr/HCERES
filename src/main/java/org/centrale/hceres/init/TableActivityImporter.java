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

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kwyhr
 */
public abstract class TableActivityImporter extends TableImporter {

    private int activityId;
    private HashMap<String, Integer> languages;

    /**
     *
     */
    public TableActivityImporter() {
        super();

        activityId = -1;
        languages = new HashMap<String, Integer>();
    }

    /**
     * Returns activity ID to insert into activity tables
     *
     * @return
     */
    protected int getActivityID() {
        return activityId;
    }

    /**
     * Get type activity
     *
     * @param connection
     * @param activityName
     * @return
     */
    private int getTypeActivity(Connection connection, String activityName) {
        int id_type_activity = -1;
        try {
            String queryTest = "SELECT id_type_activity FROM type_activity WHERE UPPER(name_type)=UPPER(?)";
            PreparedStatement preparedStatementTestActivity = connection.prepareStatement(queryTest);
            preparedStatementTestActivity.setString(1, activityName);
            ResultSet test = preparedStatementTestActivity.executeQuery();
            if (test != null) {
                if (test.next()) {
                    id_type_activity = test.getInt("id_type_activity");
                }
                test.close();
            }
            preparedStatementTestActivity.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_type_activity;
    }

    /**
     * returns language ID
     *
     * @param lang
     * @return
     */
    protected Integer getLanguageID(String lang) {
        return languages.get(lang.trim().toLowerCase());
    }

    /**
     * Main process
     *
     * @param csvReader
     * @param connection
     * @param tableName
     * @param activityName
     * @throws IOException
     * @throws SQLException
     * @throws NullPointerException
     */
    public void process(CSVReader csvReader, Connection connection, String tableName, String activityName) throws IOException, CsvException, SQLException, NullPointerException {
        init(connection);

        if (preparedStatementTest == null) {
            throw new NullPointerException();
        }
        if (preparedStatementInsert == null) {
            throw new NullPointerException();
        }
        if (preparedStatementUpdate == null) {
            throw new NullPointerException();
        }

        int typeActivityId = getTypeActivity(connection, activityName);
        if (typeActivityId <= 0) {
            throw new SQLException("Unknown Activity");
        }

        // Activities to add
        String insertActivity = "INSERT INTO Activity(ID_Type_Activity) VALUES (?) RETURNING ID_Activity";
        PreparedStatement preparedStatementAddActivity = connection.prepareStatement(insertActivity);

        // Languages
        try {
            PreparedStatement languagesStatement = connection.prepareStatement("SELECT language_id, language_name FROM Language");
            ResultSet langRes = languagesStatement.executeQuery();
            while (langRes.next()) {
                int id = langRes.getInt("language_id");
                String lang = langRes.getString("language_name").toLowerCase();
                languages.put(lang, id);
                if (lang.equals("français")) {
                    languages.put("french", id);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Process_Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Skip header
        csvReader.readNext();

        // First line
        String[] lineInArray = csvReader.readNext();
        while ((lineInArray != null) && (!lineInArray[0].isEmpty())) {
            // Reinitialize statements
            preparedStatementTest.clearParameters();
            preparedStatementInsert.clearParameters();
            preparedStatementUpdate.clearParameters();
            preparedStatementAddActivity.clearParameters();
            activityId = -1;

            // Get line elements
            loadRow(lineInArray);

            // Check if ID exists
            setTestData(preparedStatementTest);
            ResultSet test = preparedStatementTest.executeQuery();
            if ((test != null) && (!test.next())) {
                // Add activity
                preparedStatementAddActivity.setInt(1, typeActivityId);
                ResultSet addActivity = preparedStatementAddActivity.executeQuery();
                addActivity.next();
                activityId = addActivity.getInt(1);

                // Add
                setInsertData(preparedStatementInsert);
                preparedStatementInsert.executeUpdate();
            } else if (test != null) {
                // Get ID
                activityId = test.getInt(1);
                // Update
                setUpdateData(preparedStatementUpdate);
                preparedStatementUpdate.executeUpdate();
            }

            // Next line
            lineInArray = csvReader.readNext();
        }
        end(connection);
    }
}
