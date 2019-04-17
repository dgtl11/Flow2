// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 10 - JDBC
 *
 *    Thema: - 10.0 -
 *
 *  Listing: - 10.0.06 - ResultSetTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt10.xmpls.connection;

import java.sql.*;

public class ResultSetTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try (Connection dbh = DriverManager.getConnection(url, "root", "");
             Statement stmnt = dbh.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {

            ResultSet rs = stmnt.executeQuery("SELECT * FROM benutzer");
            rs.next();
            // rs.deleteRow();
            // rs.last();
            // rs.previous();

            while(rs.next()) {
                System.out.println(rs.getInt("id")+ ": " + rs.getString("vorname"));
            }

            System.out.println("-----------------------------");

            rs.previous();
            System.out.println(rs.getInt("id"));

            rs.previous();
            System.out.println(rs.getInt("id"));

            rs.first();
            System.out.println(rs.getInt("id"));

            System.out.println("-----------------------------");

            rs.beforeFirst();
            rs.afterLast();

            // rs.absolute(3);
            // System.out.println(rs.getInt("id") + ": " + rs.getString("vorname"));

            // rs.absolute(5);
            // rs.absolute(-5);         // zählt von hinten

            // rs.first();
            // rs.relative(2);
            // rs.relative(2);
            // rs.relative(4);

            rs.absolute(3);
            rs.relative(-1);

            System.out.println(rs.getInt("id") + ": " + rs.getString("vorname"));

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // MetaData of the table
            ResultSetMetaData rsmd = rs.getMetaData();
            // spaltenanzahl
            System.out.println("Spaltenzahl: " + rsmd.getColumnCount());

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            // name jeder Spalte  und typ jeder spalte
            for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i) + ": " + rsmd.getColumnTypeName(i));
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println(rsmd.getSchemaName(2));
            System.out.println(rsmd.getTableName(1));

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Connection dbh = null;
        Savepoint s1 = null;

        try {
            dbh = DriverManager.getConnection(url, "root", "");
            Statement stmnt = dbh.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM benutzer");

            dbh.setAutoCommit(false);
            stmnt.executeUpdate("UPDATE benutzer SET nachname = 'Unbekannt' WHERE id = 3");
            stmnt.executeUpdate("UPDATE benutzer SET nachname = 'Unbekannt' WHERE id = 4");
            s1 = dbh.setSavepoint();
            stmnt.executeUpdate("UPDATE benutzer SET nachname = 'Unbekannt' WHERE id = 5");
            stmnt.executeUpdate("UPDATE benutzer SET nachname = 'Unbekannt' WH_RE id = 6");

            dbh.commit();

//            rs.close();
//            System.out.println("STMT closed?: " + stmnt.isClosed());
//            stmnt.close();
//            System.out.println("DBH closed?: " + dbh.isClosed());
//            dbh.close();
        }
        catch (SQLException e) {
            try {
                dbh.rollback(s1);
                dbh.commit();
            }
            catch (SQLException ex) {
                System.out.println("Problem beim Rollback");
            }

            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
        }

        // von Hand schließen so wie
        /*
        Connection con = null;
        if (con != null)
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            */

    }
}