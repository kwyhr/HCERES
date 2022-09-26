# HCERES

**HCERES** is a project to help researchers organisation to manage their activities
# Dependencies
  * Netbeans IDE with SPRING framework installed
  * Apache Tomcat Server 9
  * DBMS to manage postgresql database (we use pgAdmin)
# Installation
**1.Connetion to the Dabase**
  * Create a database by importing the file "hceres.sql" [here](https://github.com/Ytond/HCERES/blob/main/src/main/sql/hceres.sql) in your DBMS
  * Set an user owner and a password to this database( You will need to modify if necessary the values of the tag <properties> in the file "persistence.xml"[here](https://github.com/Ytond/HCERES/blob/main/src/main/resources/META-INF/persistence.xml)

**2.Adding TomCat Server in Netbeans**
  * To configure Apache TomCat Server in Netbeans yo can follow the instructions in the following link: 
https://javapointers.com/how-to/add-tomcat-server-netbeans/ 
  
# TroubleShooting
 * Make sure that the values in the step Database Connection is OK
 * Make sure that the port of Tomcat Server is not used by others applications
