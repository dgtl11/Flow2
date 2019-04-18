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

package chpt10.de.gfn.ocp.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBHelper {

    private static final String URL = "jdbc:sqlite:" + System.getProperty("user.home") + "/benutzerVerwaltung.db";   // plattformunabhängig 


    private DBHelper() { }

    public static Connection getConnection() throws SQLException {

        // TODO: Username & passwort aus Datei lesen
        return DriverManager.getConnection(URL);
    }


}