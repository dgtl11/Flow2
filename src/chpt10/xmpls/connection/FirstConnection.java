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
import java.util.Scanner;

public class FirstConnection {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String choice = "";

        String url = "jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try (Connection dbh = DriverManager.getConnection(url, "root", "")){

            System.out.println("DatenbankVerbindung aufgebaut \n");

            while (flag) {
                System.out.println("Was wollen sie gerne machen, updaten oder auslesen ?");
                System.out.println("bitte geben sie a für auslesen oder u für update an ! ");
                System.out.println("x zum verlassen des Programms");
                choice = input.nextLine();

                switch (choice.toLowerCase()) {
                    case "a" :
                        // ein Statement
                        Statement stmnt = dbh.createStatement();
                        ResultSet results = stmnt.executeQuery("SELECT * FROM benutzer");

                        while(results.next()) {
                            System.out.printf("%d: %s %s \n", results.getInt("id"), results.getString("vorname"), results.getString("nachname") );
                        }
                        break;

                    case "u" :
                        Statement stmnt2 = dbh.createStatement();
                        String sql = "INSERT INTO benutzer (vorname, nachname) VALUES ('Clark', 'Kent')";
                        int num = stmnt2.executeUpdate(sql);
                        if(num > 0)
                            System.out.println("Gespeichert!");
                        break;

                    case "x" : flag = false;
                        break;

                    default  :
                        System.out.println("Die Eingabe war leider ungültig, probieren sie es nochmal ! ");
                }

            }

        } catch (SQLException e) {
            System.out.println("Problem beim Aufbau der Verbindung zur DB !");
            e.printStackTrace();
        }
    }

}