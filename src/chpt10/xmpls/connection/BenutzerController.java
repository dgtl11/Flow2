// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 10 - JDBC
 *
 *    Thema: - 10.0 -
 *
 *  Listing: - 10.0.02 - BenutzerController.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt10.xmpls.connection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

 public class BenutzerController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        app:
        while (true) {
            System.out.println("Was wollen sie gerne machen, updaten oder auslesen ?");
            System.out.println("bitte geben sie a für auslesen oder i für insert an ! ");
            System.out.println("u für update, d für delete, \n x zum verlassen des Programms");
            System.out.println("Auswahl: ");

            try {


                switch (scanner.nextLine().toLowerCase()) {
                    case "i": {
                        Benutzer benutzer = new Benutzer();
                        System.out.println("Vorname: ");
                        benutzer.setVorname(scanner.nextLine());

                        System.out.println("NAchname: ");
                        benutzer.setNachname(scanner.nextLine());

                        BenutzerGateway.insert(benutzer);
                        if (benutzer.getId() > 0) {
                            System.out.println("Benutzer wurde gespeichert");
                        }
                    }
                    //    try (Connection dbh = DBHelper.getConnection()) {
                    //        // PreparedStatement stmnt = dbh.prepareStatement("SELECT * FROM benutzer WHERE vorname = ? ");
                    //        PreparedStatement stmnt2 = dbh.prepareStatement("INSERT INTO benutzer (vorname, nachname) VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS);

                    //        System.out.println("Vorname: ");
                    //        String vorname = scanner.nextLine();

                    //        System.out.println("Nachname: ");
                    //        String nachname = scanner.nextLine();

                            // stmnt.setString(1, vorname);
                            // ResultSet result = stmnt.executeQuery();

                    //        stmnt2.setString(1, vorname);        // den 1. platzhalter = ?
                    //        stmnt2.setString(2, nachname);      // den 2.

                    //        stmnt2.execute();

                    //        ResultSet ids = stmnt2.getGeneratedKeys();
                    //        if (ids.next()) {
                    //            System.out.println("Gespeichert auf ID: " + ids.getInt(1));
                    //        }
                    //    } catch (SQLException e) {
                    //        System.out.println(e.getMessage());
                    //    }
                        break;

                    case "u": {

                        System.out.println("ID: ");
                        Benutzer benutzer = BenutzerGateway.find(Integer.parseInt(scanner.nextLine()));

                        System.out.println("Vorname: ");
                        benutzer.setVorname(scanner.nextLine());

                        System.out.println("Nachname: ");
                        benutzer.setNachname(scanner.nextLine());

                        if (BenutzerGateway.update(benutzer)) {
                            System.out.println("Benutzer wurde geändert ");
                        }

                    }
                        // try (Connection dbh = DBHelper.getConnection()) {
                        //    // PreparedStatement stmnt = dbh.prepareStatement("SELECT * FROM benutzer WHERE vorname = ? ");
                        //    PreparedStatement stmnt2 = dbh.prepareStatement("UPDATE benutzer SET vorname = ?, nachname= ? WHERE id = ?");
                        //
                        //    System.out.println("ID: ");
                        //    // TODO: NumberFormatException behandeln
                        //    stmnt2.setInt(3, Integer.parseInt(scanner.nextLine()));
                        //
                        //    System.out.println("Vorname: ");
                        //    // String vorname = scanner.nextLine();
                        //    stmnt2.setString(1, scanner.nextLine());
                        //
                        //    System.out.println("Nachname: ");
                        //    // String nachname = scanner.nextLine();
                        //    stmnt2.setString(2, scanner.nextLine());
                        //
                        //    // stmnt.setString(1, vorname);
                        //    // ResultSet result = stmnt.executeQuery();
                        //
                        //    // stmnt2.setString(1, vorname);        // den 1. platzhalter = ?
                        //    // stmnt2.setString(2, nachname);      // den 2.
                        //
                        //    stmnt2.execute();
                        //
                        //    // ResultSet ids = stmnt2.getGeneratedKeys();
                        //    if (stmnt2.getUpdateCount() > 0) {
                        //        System.out.println("Datensatz wurde geändert ");
                        //    }
                        // } catch (SQLException e) {
                        //    System.out.println(e.getMessage());
                        // }
                        break;


                    case "a":

                        // ResultSet results = BenutzerGateway.findAll();
                        BenutzerGateway.findAll().forEach((b) -> {
                            System.out.printf("%d: %s %s \n", b.getId(), b.getVorname(), b.getNachname());
                        });

                    // try (Connection dbh = DBHelper.getConnection()) {
                    //    Statement stmnt = dbh.createStatement();
                    //    stmnt.execute("SELECT * FROM benutzer");
                    //    ResultSet results = stmnt.getResultSet();
                    //    while (results.next()) {
                    //        System.out.printf("%d: %s %s \n", results.getInt("id"), results.getString("vorname"), results.getString("nachname"));
                    //    }
                    //    System.out.println();
                    // } catch (SQLException e) {
                    //    System.out.println(e.getMessage());
                    // }
                        break;

                    case "d":

                        System.out.println("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        if (BenutzerGateway.delete(id)) {
                            System.out.println("Datensatz wurde gelöscht");
                        }

                    //    try (Connection dbh = DBHelper.getConnection()) {
                    //        PreparedStatement stmnt = dbh.prepareStatement("DELETE FROM benutzer WHERE id = ?");
                    //
                    //        System.out.print("ID: ");
                    //        stmnt.setInt(1, Integer.parseInt(scanner.nextLine()));
                    //        stmnt.execute();
                    //
                    //        if(stmnt.getUpdateCount() > 0) {
                    //            System.out.println("Datensatz wurde gelöscht");
                    //        }
                    //    }
                    //    catch (SQLException e) {
                    //        System.out.println(e.getMessage());
                    //    }
                        break;

                    case "x":
                        break app;

                    default:
                        System.out.println("Die eingabe war nicht sinnvoll, pls try again");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}