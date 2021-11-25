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
public class Process_Researcher extends TableImporter {

    private int researcherId;
    private String researcherSurname;
    private String researcherName;
    private String researcherEmail;

    /**
     *
     */
    public Process_Researcher() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Researcher_ID FROM Researcher WHERE Researcher_ID=?";
        String theQueryInsert = "INSERT INTO Researcher(Researcher_ID,Researcher_Surname,Researcher_Name, Researcher_Email) VALUES (?, ?, ?, ?)";
        String theQueryUpdate = "UPDATE Researcher SET Researcher_Surname=?,Researcher_Name=?,Researcher_Email=? WHERE Researcher_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Researcher.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement temp = connection.prepareStatement("TRUNCATE Researcher CASCADE");
            temp.executeUpdate();
            temp = connection.prepareStatement("ALTER SEQUENCE seq_researcher RESTART WITH 1");
            temp.executeUpdate();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Researcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void end(Connection connection) {
        try {
            PreparedStatement temp = connection.prepareStatement("SELECT setval('seq_researcher', MAX(Researcher_id), true) FROM Researcher");
            temp.executeQuery();
            temp.close();
        } catch (SQLException ex) {
            Logger.getLogger(Process_Researcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        researcherId = Integer.parseInt(data[0]);
        researcherSurname = data[1].replace("\"", "").trim();
        researcherName = data[2].replace("\"", "").trim();
        researcherEmail = data[3].replace("\"", "").trim();
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, researcherId);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, researcherId);
        preparedStatement.setString(2, researcherSurname);
        preparedStatement.setString(3, researcherName);
        preparedStatement.setString(4, researcherEmail);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(4, researcherId);
        preparedStatement.setString(1, researcherSurname);
        preparedStatement.setString(2, researcherName);
        preparedStatement.setString(3, researcherEmail);
    }
}
