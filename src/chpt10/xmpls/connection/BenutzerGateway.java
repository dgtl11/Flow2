// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 10 - JDBC
 *
 *    Thema: - 10.0 -
 *
 *  Listing: - 10.0.04 - BenutzerGateway.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt10.xmpls.connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class BenutzerGateway {

    private static final String TABLE = "benutzer";

    // CRUD

    private BenutzerGateway () {

    }

    // Findet einen Datensatz nach seinere ID
    public static Benutzer find(int id) throws SQLException {
        // TODO: reagieren, wenn nichts gefunden
        return findAll("WHERE id = " + id).get(0);
    }

    public static List<Benutzer> findAll() throws SQLException {
        return findAll(null);
    }

    // findet alle Datensätze
    private static List<Benutzer> findAll(String subQuery) throws SQLException {

        List<Benutzer> list = new ArrayList<>();

        try (Connection dbh = DBHelper.getConnection();
             Statement stmnt = dbh.createStatement();
              ) {

            String sql = "SELECT * FROM " + TABLE;

            if(subQuery != null) {
                sql += " " + subQuery;
            }

            stmnt.execute(sql);
            ResultSet results = stmnt.getResultSet();
            while (results.next()) {
                list.add(create(results));
            }

            // return stmnt.getResultSet();

        }
        return list;

    }

    // einen neuen Datensatz in der DB anlegen
    public static int insert(Benutzer benutzer) throws SQLException {

        try (Connection dbh = DBHelper.getConnection();
            PreparedStatement stmnt2 = dbh.prepareStatement("INSERT INTO " + TABLE +" (vorname, nachname) VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS)
            ) {

            stmnt2.setString(1, benutzer.getVorname());        // den 1. platzhalter = ?
            stmnt2.setString(2, benutzer.getNachname());      // den 2.
            stmnt2.execute();

            ResultSet ids = stmnt2.getGeneratedKeys();
            if (ids.next()) {
                benutzer.setId(ids.getInt(1));
            }

            return benutzer.getId();
        }
    }

    public static boolean update(Benutzer benutzer) throws SQLException {

        try (Connection dbh = DBHelper.getConnection();
             PreparedStatement stmnt2 = dbh.prepareStatement("UPDATE " + TABLE + " SET vorname = ?, nachname= ? WHERE id = ?")   ) {

            stmnt2.setInt(3, benutzer.getId());
            stmnt2.setString(1, benutzer.getVorname());
            stmnt2.setString(2, benutzer.getNachname());
            stmnt2.execute();

            if (stmnt2.getUpdateCount() > 0) {
                return true;
            }
            return false;
        }
    }

    public static boolean delete(int id) throws SQLException {

        try (Connection dbh = DBHelper.getConnection()) {
            PreparedStatement stmnt = dbh.prepareStatement("DELETE FROM " + TABLE + " WHERE id = ?");

            stmnt.setInt(1, id);
            stmnt.execute();

            if(stmnt.getUpdateCount() > 0) {
                return true;
            }
        }
        return false;
    }

    private static Benutzer create(ResultSet result) throws SQLException {
        return new Benutzer(result.getInt("id"), result.getString("vorname"), result.getString("nachname"));
    }

}