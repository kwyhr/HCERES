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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kwyhr
 */
public class Process_Laboratory extends TableImporter {

    private int laboratoryId;
    private String laboratoryName;
    private String laboratoryAcronym;
    private int institutionId;

    /**
     *
     */
    public Process_Laboratory() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Laboratory_ID FROM Laboratory WHERE Laboratory_Acronym=?";
        String theQueryInsert = "INSERT INTO Laboratory(Laboratory_ID,Laboratory_Name,Laboratory_Acronym,Institution_ID) VALUES (?, ?, ?, ?)";
        String theQueryUpdate = "UPDATE Laboratory SET Laboratory_ID=? WHERE Laboratory_Acronym=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Laboratory.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement temp = connection.prepareStatement("TRUNCATE Laboratory CASCADE");
            temp.executeUpdate();
            temp = connection.prepareStatement("ALTER SEQUENCE seq_laboratory RESTART WITH 1");
            temp.executeUpdate();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Laboratory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void end(Connection connection) {
        try {
            PreparedStatement temp = connection.prepareStatement("SELECT setval('seq_laboratory', MAX(laboratory_id), true) FROM Laboratory");
            temp.executeQuery();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Laboratory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        laboratoryId = Integer.parseInt(data[0]);
        laboratoryName = data[1].replace("\"", "").trim();
        laboratoryAcronym = data[2].replace("\"", "").trim();
        institutionId = Integer.parseInt(data[3]);
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, laboratoryAcronym);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, laboratoryId);
        preparedStatement.setString(2, laboratoryName);
        preparedStatement.setString(3, laboratoryAcronym);
        preparedStatement.setInt(4, institutionId);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(2, laboratoryAcronym);
        preparedStatement.setInt(1, laboratoryId);
    }

}
