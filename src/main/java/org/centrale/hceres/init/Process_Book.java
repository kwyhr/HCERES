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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.centrale.tools.Utilities;

/**
 *
 * @author kwyhr
 */
public class Process_Book extends TableActivityImporter {

    private Date publicationDate;
    private String title;
    private String editor;
    private String authors;
    private Integer lang;

    /**
     *
     */
    public Process_Book() {
        super();
    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT ID_Activity FROM Book WHERE UPPER(Title)=UPPER(?)";
        String theQueryInsert = "INSERT INTO Book(ID_Activity, Publication_Date, Title, Editor, Nb_Page, Authors, Language_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String theQueryUpdate = "UPDATE Book SET Title=? WHERE ID_Activity=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Book.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void loadRow(String[] data) {
        String idStr = data[0]; // don't care, is renumbered
        String publiDate = data[1];
        String tempTitle = data[2];
        String tempEditor = data[3];
        String tempAuthors = data[4];
        String tempLang = data[5];

        // Publication date
        publiDate = publiDate.trim();
        if (publiDate.length() == 8) {
            // Old format
            int year = Integer.parseInt(publiDate.substring(6));
            if (year > 70) {
                publiDate = publiDate.substring(0, 6) + "19" + publiDate.substring(6);
            } else {
                publiDate = publiDate.substring(0, 6) + "20" + publiDate.substring(6);
            }
        }
        publicationDate = Utilities.isDate(publiDate);

        // title
        tempTitle = tempTitle.trim();
        while ((tempTitle.startsWith("\"")) && (tempTitle.endsWith("\""))) {
            tempTitle = tempTitle.substring(1, tempTitle.length() - 2);
        }
        title = tempTitle.replace("\"\"", "\"").trim();

        editor = tempEditor.trim();

        authors = tempAuthors.trim();

        lang = getLanguageID(tempLang.trim());
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, this.getActivityID());
        preparedStatement.setDate(2, new java.sql.Date(publicationDate.getTime()));
        preparedStatement.setString(3, title);
        if (editor.isEmpty()) {
            preparedStatement.setNull(4, java.sql.Types.INTEGER);
        } else {
            preparedStatement.setString(4, editor);
        }
        preparedStatement.setNull(5, java.sql.Types.INTEGER);
        preparedStatement.setString(6, authors);
        if ((lang == null) || (lang <= 0)) {
            preparedStatement.setNull(7, java.sql.Types.INTEGER);
        } else {
            preparedStatement.setInt(7, lang);
        }
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, this.getActivityID());
    }

}
