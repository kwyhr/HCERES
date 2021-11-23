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
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * No protection for the class because it should be called ONLY by package
 * classes
 *
 * @author kwyhr
 */
class ApplicationImporter {

    /**
     * No protection for the constructor because it should be called ONLY by
     * package classes
     */
    ApplicationImporter() {

    }

    /**
     * Process file data
     *
     * @param csvReader
     * @param connection
     * @param tableName
     * @throws IOException
     */
    public void parseFile(CSVReader csvReader, Connection connection, String tableName) throws IOException, CsvException, SQLException {
        // Next line contains table columns name
        List<String> fileHeader = getFileHeader(csvReader);
        HashMap<String, Integer> tableMapType = getTableTypes(connection, tableName);

        // Prepare test and insert statements according to header
        String theQueryTest = getQueryStringSelect(tableName, fileHeader, tableMapType);
        String theQueryInsert = getQueryStringInsert(tableName, fileHeader, tableMapType);
        String theQueryInsertSerial = getQueryStringInsertSerial(tableName, fileHeader, tableMapType);
        PreparedStatement preparedStatementTest = connection.prepareStatement(theQueryTest);
        PreparedStatement preparedStatementInsert = connection.prepareStatement(theQueryInsert);
        PreparedStatement preparedStatementInsertSerial = connection.prepareStatement(theQueryInsertSerial);

        // Parse file
        int valueI;
        double valueD;
        Date aDate;
        java.sql.Date sqlDate;
        int rowSize = fileHeader.size();
        String[] row = csvReader.readNext();
        while ((row != null) && (! row[0].isEmpty())) {
            preparedStatementTest.clearParameters();
            preparedStatementInsert.clearParameters();
            preparedStatementInsertSerial.clearParameters();

            int index = 0;
            int indexSerial = 0;
            boolean mustInsert = false;
            int realRowSize = row .length;
            for (int indRow = 0; indRow < rowSize; indRow++) {
                String aDataValue = "";
                if (indRow < realRowSize) {
                    aDataValue = row [indRow];
                    String columnName = fileHeader.get(index);
                    int dataType = tableMapType.get(columnName);

                    index++;
                    indexSerial++;

                    // Set data according to its type
                    switch (dataType) {
                        case 1:
                            preparedStatementTest.setString(index, aDataValue);
                            preparedStatementInsert.setString(index, aDataValue);
                            preparedStatementInsertSerial.setString(indexSerial, aDataValue);
                            break;
                        case 2:
                            valueI = Integer.parseInt(aDataValue);
                            preparedStatementTest.setInt(index, valueI);
                            preparedStatementInsert.setObject(index, valueI);
                            preparedStatementInsertSerial.setObject(indexSerial, valueI);
                            break;
                        case 3:
                            valueD = Double.parseDouble(aDataValue);
                            preparedStatementTest.setDouble(index, valueD);
                            preparedStatementInsert.setDouble(index, valueD);
                            preparedStatementInsertSerial.setDouble(indexSerial, valueD);
                            break;
                        case 4:
                            if (!aDataValue.isEmpty()) {
                                valueI = Integer.parseInt(aDataValue);
                                preparedStatementTest.setInt(index, valueI);
                                preparedStatementInsert.setInt(index, valueI);
                                preparedStatementInsertSerial.setInt(indexSerial, valueI);
                            } else {
                                mustInsert = true;
                            }
                            indexSerial--;
                            break;
                        case 5:
                            aDate = isDate(aDataValue);
                            sqlDate = java.sql.Date.valueOf(aDate.toString());
                            preparedStatementTest.setDate(index, sqlDate);
                            preparedStatementInsert.setDate(index, sqlDate);
                            preparedStatementInsertSerial.setDate(indexSerial, sqlDate);
                            break;
                        case 6:
                            aDate = isTimestamp(aDataValue);
                            sqlDate = java.sql.Date.valueOf(aDate.toString());
                            preparedStatementTest.setDate(index, sqlDate);
                            preparedStatementInsert.setDate(index, sqlDate);
                            preparedStatementInsertSerial.setDate(indexSerial, sqlDate);
                            break;
                    }
                }
            }
            if (!mustInsert) {
                ResultSet test = preparedStatementTest.executeQuery();
                if ((test != null) && (!test.next())) {
                    // Does not exist in table, insert it
                    mustInsert = true;
                }
            }

            if (mustInsert) {
                // serial is empty => insert
                if (indexSerial == index) {
                    preparedStatementInsert.executeUpdate();
                } else {
                    preparedStatementInsertSerial.executeUpdate();
                }
            }
            row = csvReader.readNext();
        }
        preparedStatementTest.close();
        preparedStatementInsert.close();
        preparedStatementInsertSerial.close();

        // If the hashmap contains a serial value => update serial value
        updateSequence(connection, tableName, tableMapType);

    }

    /**
     * Get file data header
     *
     * @param csvReader
     * @return
     * @throws IOException
     */
    private List<String> getFileHeader(CSVReader csvReader) throws IOException, CsvException {
        List<String> returnedValue = new ArrayList<String>();
        String[] row = csvReader.readNext();
        if (! row[0].isEmpty()) {
            for (String anHeader : row) {
                returnedValue.add(anHeader.toLowerCase());
            }
        }
        return returnedValue;
    }

    private HashMap<String, Integer> getTableTypes(Connection connection, String tableName) {
        HashMap<String, Integer> tableMapType = new HashMap<String, Integer>();
        try {
            String theQueryMeta = "SELECT * FROM " + tableName + " LIMIT 1";
            PreparedStatement preparedStatementMeta = connection.prepareStatement(theQueryMeta);
            ResultSetMetaData metaData = preparedStatementMeta.getMetaData();
            int paramCount = metaData.getColumnCount();
            for (int param = 1; param <= paramCount; param++) {
                String paramName = metaData.getColumnName(param).toLowerCase();
                String paramTypeName = metaData.getColumnTypeName(param).toLowerCase();
                if ((paramTypeName.equals("varchar")) || (paramTypeName.equals("text"))) {
                    tableMapType.put(paramName, 1);
                } else if ((paramTypeName.equals("int4")) || (paramTypeName.equals("int8"))) {
                    tableMapType.put(paramName, 2);
                } else if ((paramTypeName.equals("serial"))) {
                    tableMapType.put(paramName, 4);
                } else if (paramTypeName.equals("date")) {
                    tableMapType.put(paramName, 5);
                } else if (paramTypeName.equals("timestamp")) {
                    tableMapType.put(paramName, 6);
                } else {
                    tableMapType.put(paramName, 3);
                }
            }
            preparedStatementMeta.close();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableMapType;
    }

    private String getQueryStringSelect(String tableName, List<String> fileHeader, HashMap<String, Integer> tableMapType) {
        StringBuilder theQueryTest = new StringBuilder();

        theQueryTest.append("SELECT * FROM ");
        theQueryTest.append(tableName);
        theQueryTest.append(" WHERE ");

        int nbFields = 0;
        for (String aKey : fileHeader) {
            String keyName = aKey.toLowerCase();
            if (tableMapType.get(keyName) != null) {
                if (nbFields > 0) {
                    theQueryTest.append(" AND ");
                }
                nbFields++;
                theQueryTest.append(keyName);
                theQueryTest.append("=?");
            }
        }

        return theQueryTest.toString();
    }

    private String getQueryStringInsert(String tableName, List<String> fileHeader, HashMap<String, Integer> tableMapType) {
        StringBuilder theQueryInsert = new StringBuilder();

        theQueryInsert.append("INSERT INTO ");
        theQueryInsert.append(tableName);
        theQueryInsert.append("(");

        int nbFields = 0;
        for (String aKey : fileHeader) {
            String keyName = aKey.toLowerCase();
            if (tableMapType.get(keyName) != null) {
                if (nbFields > 0) {
                    theQueryInsert.append(",");
                }
                nbFields++;
                theQueryInsert.append(keyName);
            }
        }
        theQueryInsert.append(") VALUES (");
        for (int i = 0; i < nbFields; i++) {
            if (i == 0) {
                theQueryInsert.append("?");
            } else {
                theQueryInsert.append(",?");
            }
        }
        theQueryInsert.append(")");

        return theQueryInsert.toString();
    }

    private String getQueryStringInsertSerial(String tableName, List<String> fileHeader, HashMap<String, Integer> tableMapType) {
        StringBuilder theQueryInsert = new StringBuilder();

        theQueryInsert.append("INSERT INTO ");
        theQueryInsert.append(tableName);
        theQueryInsert.append("(");

        int nbFields = 0;
        for (String aKey : fileHeader) {
            String keyName = aKey.toLowerCase();
            if ((tableMapType.get(keyName) != null) && (tableMapType.get(keyName) != 4)) {
                if (nbFields > 0) {
                    theQueryInsert.append(",");
                }
                nbFields++;
                theQueryInsert.append(keyName);
            }
        }
        theQueryInsert.append(") VALUES (");
        for (int i = 0; i < nbFields; i++) {
            if (i == 0) {
                theQueryInsert.append("?");
            } else {
                theQueryInsert.append(",?");
            }
        }
        theQueryInsert.append(")");

        return theQueryInsert.toString();
    }

    /**
     * Update sequence
     *
     * @param connection
     * @param tableName
     * @param tableMapType
     */
    private void updateSequence(Connection connection, String tableName, HashMap<String, Integer> tableMapType) {
        boolean hasSerial = false;
        String colSerialName = "";
        for (String key : tableMapType.keySet()) {
            if (tableMapType.get(key) == 4) {
                hasSerial = true;
                colSerialName = key;
                break;
            }
        }
        if (hasSerial) {
            // Update sequence to the max value met
            try {
                // Get max value
                PreparedStatement preparedStatementMaxSeq = connection.prepareStatement("SELECT MAX(" + colSerialName + ") FROM " + tableName);
                ResultSet testMax = preparedStatementMaxSeq.executeQuery();
                testMax.next();
                int max = testMax.getInt(1);
                preparedStatementMaxSeq.close();

                // Update sequence
                String seqName = "seq_" + tableName.toLowerCase();
                PreparedStatement preparedStatementUpdateSeq;
                if (max > 0) {
                    preparedStatementUpdateSeq = connection.prepareStatement("SELECT pg_catalog.setval('seq_" + tableName.toLowerCase() + "', " + max + ", true);");
                } else {
                    preparedStatementUpdateSeq = connection.prepareStatement("SELECT pg_catalog.setval('seq_" + tableName.toLowerCase() + "', 1, false);");
                }
                preparedStatementUpdateSeq.executeQuery();
                preparedStatementUpdateSeq.close();
            } catch (SQLException ex) {
                // Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Check if a String is a Time and returns the Date, null otherwise
     *
     * @param aTime
     * @return
     */
    private static Date checkDateFormats(String aTime, LinkedList<String> possibleFormats) {
        Date returnedValue = null;
        if (aTime != null) {
            if (!aTime.equals("")) {
                String format = null;
                while ((returnedValue == null) && (!possibleFormats.isEmpty())) {
                    format = possibleFormats.removeFirst();

                    try {
                        // Hour, Minustes and seconds
                        SimpleDateFormat aFormater = new SimpleDateFormat(format);
                        returnedValue = aFormater.parse(aTime);
                    } catch (ParseException ex) {
                    }
                }

                if (returnedValue != null) {
                    Calendar aCalendar = Calendar.getInstance();
                    aCalendar.setTime(returnedValue);
                    possibleFormats.addFirst(format);
                }
            }
        }

        return returnedValue;
    }

    /**
     * Check if a String is a timestamp and returns the Date, null otherwise
     *
     * @param aDate
     * @return
     */
    public static Date isTimestamp(String aDate) {
        LinkedList<String> possibleFormats = new LinkedList<String>();
        possibleFormats.add("dd/MM/yyyy");
        possibleFormats.add("yyyy-MM-dd");
        possibleFormats.add("yyyy-dd-MM");

        checkDateFormats(aDate, possibleFormats);
        String format = possibleFormats.removeFirst();

        possibleFormats.clear();
        possibleFormats.add(format + " HH:mm:ss");
        possibleFormats.add(format + " HH:mm");
        possibleFormats.add(format + " HH");

        Date returnedValue = checkDateFormats(aDate, possibleFormats);
        return returnedValue;
    }

    /**
     * Check if a String is a Date and returns the Date, null otherwise
     *
     * @param aDate
     * @return
     */
    public static Date isDate(String aDate) {
        LinkedList<String> possibleFormats = new LinkedList<String>();
        possibleFormats.add("dd/MM/yyyy");
        possibleFormats.add("yyyy-MM-dd");
        possibleFormats.add("yyyy-dd-MM");

        Date returnedValue = checkDateFormats(aDate, possibleFormats);
        return returnedValue;
    }

    /**
     * Check if a String is a Time and returns the Date, null otherwise
     *
     * @param aTime
     * @return
     */
    public static Date isTime(String aTime) {
        LinkedList<String> possibleFormats = new LinkedList<String>();
        possibleFormats.add("HH:mm:ss");
        possibleFormats.add("HH:mm");
        possibleFormats.add("HH");

        Date returnedValue = checkDateFormats(aTime, possibleFormats);
        return returnedValue;
    }

    /* ----------------------------------------------------------------------- */
}
