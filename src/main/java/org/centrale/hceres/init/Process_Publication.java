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
public class Process_Publication extends TableActivityImporter {

    private String title;
    private String authors;
    private String source;
    private int publication_type;
    private Date publicationDate;
    private String pmid;
    private Float impactFactor;

    /**
     *
     */
    public Process_Publication() {
        super();
    }

    @Override
    public void init(Connection connection) {
        String theQueryTest = "SELECT ID_Activity FROM Publication WHERE UPPER(Title)=UPPER(?)";
        String theQueryInsert = "INSERT INTO Publication(ID_Activity, Title, Authors, Source, Publication_Date, Publication_Type_ID, PMID, Impact_Factor) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String theQueryUpdate = "UPDATE Publication SET Title=? WHERE ID_Activity=?";

        try {
            setPreparedStatementTest(connection, theQueryTest);
            setPreparedStatementInsert(connection, theQueryInsert);
            setPreparedStatementUpdate(connection, theQueryUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(Process_Publication.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void loadRow(String[] data) {
        String idStr = data[0]; // don't care, is renumbered
        String tempTitle = data[1];
        String tempAuthors = data[2];
        String tempSource = data[3];
        String publiDate = data[4];
        String tempPMID = data[5];
        String tempFactor = data[6];
        
        // Publication date
        publicationDate = Utilities.isDate(publiDate);

        // title
        tempTitle = tempTitle.trim();
        while ((tempTitle.startsWith("\"")) && (tempTitle.endsWith("\""))) {
            tempTitle = tempTitle.substring(1, tempTitle.length() - 2);
        }
        title = tempTitle.replace("\"\"", "\"").trim();

        authors = tempAuthors.trim();

        source = tempSource.trim();
        
        publication_type = 1;
        
        pmid = tempPMID.trim();
        
        impactFactor =  Float.parseFloat(tempFactor);
        
    }

    @Override
    public void setTestData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
    }

    @Override
    public void setInsertData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, this.getActivityID());
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, authors);
        preparedStatement.setString(4, source);
        preparedStatement.setDate(5, new java.sql.Date(publicationDate.getTime()));
        preparedStatement.setInt(6, publication_type);
        preparedStatement.setString(7, pmid);
        preparedStatement.setFloat(8, impactFactor);
    }

    @Override
    public void setUpdateData(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, this.getActivityID());
    }

}
