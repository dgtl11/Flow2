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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class FirstConnection {
    public static void main(String[] args) {

        Properties prop = new Properties();
        // schreiben
//         prop.setProperty("db.host", "localhost");
//         prop.setProperty("db.port", "3306");
//         prop.setProperty("db.user", "root");
//         prop.setProperty("db.password", "");

        try {
            // prop.store(new FileOutputStream("config.properties"), null);     // schreiben
            prop.load(new FileInputStream("config.properties"));           // laden
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }

        // Eigenschaften aus Datei lesen
        // prop.getProperty("de.user");

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        String choice = "";
        String vorname = "";
        String name = "";
        String deleteID = "";

        String url = "jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try (   // Connection dbh = DriverManager.getConnection(url, prop.getProperty("db.user"), prop.getProperty("db.password"));       // oder setProperty muss genau user und password nicht de.user oder de.password
                // oder direkt properties aus datei ziehen
                Connection dbh = DriverManager.getConnection(url, "root", "");
                Statement stmnt = dbh.createStatement();
             ){

            System.out.println("DatenbankVerbindung aufgebaut \n");

            while (flag) {
                System.out.println("Was wollen sie gerne machen, updaten oder auslesen ?");
                System.out.println("bitte geben sie a für auslesen oder i für insert an ! ");
                System.out.println("d für delete, x zum verlassen des Programms");
                choice = input.nextLine();

                switch (choice.toLowerCase()) {
                    case "a" :
                        // kein Statement create
                        ResultSet results = stmnt.executeQuery("SELECT * FROM benutzer");
                        // ResultSet results = stmnt.execute("SELECT * FROM benutzer");
                        while(results.next()) {
                            System.out.printf("%d: %s %s \n", results.getInt("id"), results.getString("vorname"), results.getString("nachname") );
                        }
                        System.out.println();
                        break;

                    case "i" :
                        System.out.println("bitte vorname des neuen users angeben: ");
                        vorname = input.nextLine();
                        System.out.println("bitte gib den nachnamen des neuen users an: ");
                        name = input.nextLine();
                        // Statement stmnt2 = dbh.createStatement()
                        // String sql = "INSERT INTO benutzer (vorname, nachname) VALUES ('"+vorname+"', '"+name+"')";
                        String sql = String.format("INSERT INTO benutzer (vorname, nachname) VALUES ('%s', '%s')", vorname, name);

                        // int num = stmnt.executeUpdate(sql);
                        stmnt.execute(sql, Statement.RETURN_GENERATED_KEYS);
                        ResultSet ids = stmnt.getGeneratedKeys();

                        if (ids.next()) {
                            System.out.println("Gespeichert mit der ID: " + ids.getInt(1));
                        }

                        // if(stmnt.getUpdateCount() > 0 )
                        //     System.out.println(vorname + " " + name + " gespeichert! \n");
                        break;

                    case "d" :
                        System.out.println("Welchen User wollen sie löschen ? ");
                        System.out.println("bitte die id des users angeben: ");
                        deleteID = input.nextLine();

                        // Statement stmnt3 = dbh.createStatement();
                        String sq2 = "DELETE FROM benutzer WHERE id =" + deleteID + " " ;
                        int num2 = stmnt.executeUpdate(sq2);
                        if (num2 > 0)
                            System.out.println("user " + deleteID + " deleted \n");
                        else System.out.println("nichts passiert ");
                        break;

                    case "x" : flag = false;
                        break;

                    default  :
                        System.out.println("Die Eingabe war leider ungültig, probieren sie es nochmal ! \n ");
                }

            }

        } catch (SQLException e) {
            System.out.println("Problem beim Aufbau der Verbindung zur DB ! \n");
            e.printStackTrace();
        }
    }

}