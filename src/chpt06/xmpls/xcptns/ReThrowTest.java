// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.3 - rethrowing xcptns
 *
 *  Listing: - 06.3.06 - ReThrowTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.xcptns;


import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class ReThrowTest {

    public void parseData() throws SQLException, DateTimeParseException {
    }

    public void multiCatch() throws SQLException, DateTimeParseException {
        try {
            parseData();
        } catch (SQLException | DateTimeParseException e) {
            System.err.println(e);
            throw e;
        }
    }

    public void rethrowing() throws SQLException, DateTimeParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    public void parseData2() throws IOException, SQLException, DateTimeParseException {
    }

    public void multiCatch2() throws IOException, SQLException, DateTimeParseException {
        /*
        try {
            parseData();
        } catch (IOException | SQLException | DateTimeParseException e) {
            System.err.println(e);
            throw e;
        } */
        try {
            parseData();
        } catch (SQLException | DateTimeParseException e) {
            System.err.println(e);
            throw e;
        }
    }

    public void rethrowing2() throws IOException , SQLException,
            DateTimeParseException {
        try {
            parseData();
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
    }

    public void multiCatch3() throws IOException, SQLException, DateTimeParseException {
        parseData();
        /* try {
            parseData();
        } catch (IOException | DateTimeParseException e) {
            System.err.println(e);
            throw e;
        } } */
    }
}

