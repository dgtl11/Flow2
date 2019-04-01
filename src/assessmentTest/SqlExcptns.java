// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.09 - SqlExcptns.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlExcptns {

    public void stmt(Connection conn, int a) throws SQLException {
        Statement stmt = conn.createStatement(a, ResultSet.CONCUR_READ_ONLY );
        // Statement stmt2 = conn.createStatement(a, ResultSet.CONCUR_INSERTABLE);
        Statement stmt3 = conn.createStatement(a, ResultSet.CONCUR_UPDATABLE);
        Statement stmt4 = conn.createStatement(a, ResultSet.TYPE_FORWARD_ONLY);
        Statement stmt5 = conn.createStatement(a, ResultSet.TYPE_SCROLL_INSENSITIVE);
        Statement stmt6 = conn.createStatement(a, ResultSet.TYPE_SCROLL_SENSITIVE);
    }
    public static void main(String[] args) {

    }
}