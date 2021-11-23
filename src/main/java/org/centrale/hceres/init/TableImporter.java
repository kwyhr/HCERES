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
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kwyhr
 */
public abstract class TableImporter {

    protected PreparedStatement preparedStatementTest;
    protected PreparedStatement preparedStatementInsert;
    protected PreparedStatement preparedStatementUpdate;

    /**
     *
     */
    public TableImporter() {
        preparedStatementTest = null;
        preparedStatementInsert = null;
        preparedStatementUpdate = null;
    }

    /**
     * close dstatements
     */
    protected void close() {
        try {
            if (preparedStatementTest != null) {
                preparedStatementTest.close();
            }
            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }
            if (preparedStatementUpdate != null) {
                preparedStatementUpdate.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * init
     *
     * @param connection
     */
    protected abstract void init(Connection connection);

    /**
     * End connection to the table
     * @param connection 
     */
    protected void end(Connection connection) {
        
    }
    
    /**
     * define teststatement to check line exists
     *
     * @param connection
     * @param request
     * @throws SQLException
     */
    protected void setPreparedStatementTest(Connection connection, String request) throws SQLException {
        this.preparedStatementTest = connection.prepareStatement(request);
    }

    /**
     * Set insert statement
     *
     * @param connection
     * @param request
     * @throws SQLException
     */
    protected void setPreparedStatementInsert(Connection connection, String request) throws SQLException {
        this.preparedStatementInsert = connection.prepareStatement(request);
    }

    /**
     * Set update statement
     *
     * @param connection
     * @param request
     * @throws SQLException
     */
    protected void setPreparedStatementUpdate(Connection connection, String request) throws SQLException {
        this.preparedStatementUpdate = connection.prepareStatement(request);
    }

    /**
     * Load data from row
     *
     * @param data
     */
    protected abstract void loadRow(String[] data);

    /**
     * Set test data
     *
     * @param preparedStatement
     * @throws java.sql.SQLException
     */
    protected abstract void setTestData(PreparedStatement preparedStatement) throws SQLException;

    /**
     * Set insert data
     *
     * @param preparedStatement
     * @throws java.sql.SQLException
     */
    protected abstract void setInsertData(PreparedStatement preparedStatement) throws SQLException;

    /**
     * Set update data
     *
     * @param preparedStatement
     * @throws java.sql.SQLException
     */
    protected abstract void setUpdateData(PreparedStatement preparedStatement) throws SQLException;
    
    /**
     * Main process
     *
     * @param csvReader
     * @param connection
     * @param tableName
     * @throws IOException
     * @throws SQLException
     * @throws NullPointerException
     */
    public void process(CSVReader csvReader, Connection connection, String tableName) throws IOException, CsvException, SQLException, NullPointerException {
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

        // Skip header
        csvReader.readNext();

        // First line
        String[] lineInArray = csvReader.readNext();
        while ((lineInArray != null) && (!lineInArray[0].isEmpty())) {
            // Remove leading and ending spaces, remove tabs
            // Reinitialize statements
            preparedStatementTest.clearParameters();
            preparedStatementInsert.clearParameters();
            preparedStatementUpdate.clearParameters();

            // Get line elements
            loadRow(lineInArray);

            // Check if ID exists
            setTestData(preparedStatementTest);
            ResultSet test = preparedStatementTest.executeQuery();
            if ((test != null) && (!test.next())) {
                // Add
                setInsertData(preparedStatementInsert);
                preparedStatementInsert.executeUpdate();
            } else {
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
