// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 10 - JDBC
 *
 *    Thema: - 10.1 - Connection
 *
 *  Listing: - 10.0.01 - FirstConnection.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt10.xmpls.connection;

import java.sql.*;

public class FirstConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try (Connection dbh = DriverManager.getConnection(url, "root", "")){

            //  System.out.println("Super");
            // ein Statement
            Statement stmnt = dbh.createStatement();
            ResultSet results = stmnt.executeQuery("SELECT * FROM benutzer");

            while(results.next()) {
                 System.out.printf("%d: %s %s \n", results.getInt("id"), results.getString("vorname"), results.getString("nachname") );
            }

            /*
            String sql = "INSERT INTO benutzer (vorname, nachname) VALUES ('Clark', 'Kent')";
            int num = stmnt.executeUpdate(sql);
            if(num > 0)
               System.out.println("Gespeichert!");
            */

        } catch (SQLException e) {
            System.out.println("Problem!");
            e.printStackTrace();
        }
        
    }
}