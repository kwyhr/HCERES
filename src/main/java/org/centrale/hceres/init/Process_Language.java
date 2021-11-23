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
public class Process_Language extends TableImporter {

    private int id;
    private String name;

    /**
     *
     */
    public Process_Language() {
        super();

    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT Language_ID FROM Language WHERE Language_ID=?";
        String theQueryInsert = "INSERT INTO Language(Language_ID, Language_Name) VALUES (?, ?)";
        String theQueryUpdate = "UPDATE Language SET Language_Name=? WHERE Language_ID=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Language.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadRow(String[] data) {
        String idStr = data[0];
        id = Integer.parseInt(idStr);
        name = data[1].replace("\"", "").trim();
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(2, id);
        preparedStatement.setString(1, name);
    }

}
