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
public class Process_Status extends TableImporter {

    private int idStatus;
    private String nameStatus;

    /**
     *
     */
    public Process_Status() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT ID_Status FROM Status WHERE ID_Status=?";
        String theQueryInsert = "INSERT INTO Status(ID_Status,Name_Status) VALUES (?, ?)";
        String theQueryUpdate = "UPDATE Status SET Name_Status=? WHERE Status_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Status.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement temp = connection.prepareStatement("TRUNCATE Status CASCADE");
            temp.executeUpdate();
            temp = connection.prepareStatement("ALTER SEQUENCE seq_status RESTART WITH 1");
            temp.executeUpdate();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void end(Connection connection) {
        try {
            PreparedStatement temp = connection.prepareStatement("SELECT setval('seq_status', MAX(ID_Status), true) FROM Status");
            temp.executeQuery();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        idStatus = Integer.parseInt(data[0]);
        nameStatus = data[1].replace("\"", "").trim();
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, idStatus);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, idStatus);
        preparedStatement.setString(2, nameStatus);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(2, idStatus);
        preparedStatement.setString(1, nameStatus);
    }

}
