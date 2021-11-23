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
public class Process_Nationality extends TableImporter {

    private int nationalityId;
    private String nationalityName;

    /**
     *
     */
    public Process_Nationality() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Nationality_ID FROM Nationality WHERE Nationality_Name=?";
        String theQueryInsert = "INSERT INTO Nationality(Nationality_ID,Nationality_Name) VALUES (?, ?)";
        String theQueryUpdate = "UPDATE Nationality SET Nationality_Name=? WHERE Nationality_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement temp = connection.prepareStatement("TRUNCATE Nationality CASCADE");
            temp.executeUpdate();
            temp = connection.prepareStatement("ALTER SEQUENCE seq_Nationality RESTART WITH 1");
            temp.executeUpdate();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void end(Connection connection) {
        try {
            PreparedStatement temp = connection.prepareStatement("SELECT setval('seq_nationality', MAX(Nationality_id), true) FROM Nationality");
            temp.executeQuery();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Nationality.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        nationalityId = Integer.parseInt(data[0]);
        nationalityName = data[1].replace("\"", "").trim();
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, nationalityName);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, nationalityId);
        preparedStatement.setString(2, nationalityName);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(2, nationalityId);
        preparedStatement.setString(1, nationalityName);
    }

}
