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
public class Process_Belongs_team extends TableImporter {

    private int researcherId;
    private int teamId;

    /**
     *
     */
    public Process_Belongs_team() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Team_ID FROM Belongs_Team WHERE Researcher_ID=?";
        String theQueryInsert = "INSERT INTO Belongs_Team(Researcher_ID, Team_ID) VALUES (?, ?)";
        String theQueryUpdate = "UPDATE Belongs_Team SET Team_ID=? WHERE Researcher_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Belongs_team.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        researcherId = Integer.parseInt(data[0]);
        teamId = Integer.parseInt(data[1]);
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, researcherId);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, researcherId);
        preparedStatement.setInt(2, teamId);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(2, researcherId);
        preparedStatement.setInt(1, teamId);
    }

}
