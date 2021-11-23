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
public class Process_Team extends TableImporter {

    private int teamId;
    private String teamName;
    private int laboratoryId;

    /**
     *
     */
    public Process_Team() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Team_ID FROM Team WHERE Team_Name=?";
        String theQueryInsert = "INSERT INTO Team(Team_ID,Team_Name,Laboratory_ID) VALUES (?, ?, ?)";
        String theQueryUpdate = "UPDATE Team SET Team_Name=? WHERE Team_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Team.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement temp = connection.prepareStatement("TRUNCATE Team CASCADE");
            temp.executeUpdate();
            temp = connection.prepareStatement("ALTER SEQUENCE seq_team RESTART WITH 1");
            temp.executeUpdate();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Team.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void end(Connection connection) {
        try {
            PreparedStatement temp = connection.prepareStatement("SELECT setval('seq_team', MAX(Team_id), true) FROM Team");
            temp.executeQuery();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Team.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        teamId = Integer.parseInt(data[0]);
        teamName = data[1].replace("\"", "").trim();
        laboratoryId = Integer.parseInt(data[2]);
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, teamName);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, teamId);
        preparedStatement.setString(2, teamName);
        preparedStatement.setInt(3, laboratoryId);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(2, teamId);
        preparedStatement.setString(1, teamName);
    }

}
