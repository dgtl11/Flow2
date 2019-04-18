// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 10 - JDBC
 *
 *    Thema: - 10.0 -
 *
 *  Listing: - 10.0.03 - DBHelper.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt10.de.gfn.ocp.benutzerverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    private DBHelper() { }

    public static Connection getConnection() throws SQLException {

        // TODO: Username & passwort aus Datei lesen
        return DriverManager.getConnection(URL, "root", "");
    }


}