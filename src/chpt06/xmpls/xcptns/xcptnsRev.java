// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.1 - Review Exceptions
 *
 *  Listing: - 06.1.01 - ThrowVsThrows.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.xcptns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

// custom xcptns
class CannotSwimException extends Exception {

    public CannotSwimException() {
        super();
    }
    public CannotSwimException(Exception e) {
        super(e);
    }
    public CannotSwimException(String message) {
        super(message);
    }
}
class DangerInTheWater extends RuntimeException {}
class SharkInTheWaterException extends DangerInTheWater {}
class Dolphin {
    public void swim() throws CannotSwimException {
        // logic here
    }
}

public class xcptnsRev {
    public static void main(String[] args) {

        // try and catch
        try {
            throw new CannotSwimException();
        } catch (CannotSwimException e) {
            e.printStackTrace();
        }

        // multi catch
        // the old way:
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // bad abproach
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (Exception e) {     // BAD approach
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // create a helper meth
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException e) {
            handleException(e);
        } catch (IOException e) {
            handleException(e);
        }

        // solution : Multi-Catch
        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // syntax of multi-catch
        // catch(Exception1 e | Exception2 e | Exception3 e)// DOES NOT COMPILE
        // catch(Exception1 e1 | Exception2 e2 | Exception3 e3) // DOES NOT COMPILE

        // catch(Exception1 | Exception2 | Exception3 e)

        // not the same: The exception FileNotFoundException is already caught by the alternative IOException
        /*try {
            throw new IOException();
        } catch (FileNotFoundException | IOException e) { } // DOES NOT COMPILE
        -->
        try {
            throw new IOException();
        } catch (IOException e) { }
        */

        // legal but bad idea reassign the variable
        /* try {
            // do some work
        } catch(RuntimeException e) {
            e = new RuntimeException();
        }

        with multi catch u even cant
        try {
            throw new IOException();
        } catch(IOException | RuntimeException e) {
            e = new RuntimeException();     // DOES NOT COMPILE
        }
        */


    }


    // create a helper meth
    private static void handleException(Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }

        // ThrowVsThrows
    public String getDataFromDatabase() throws SQLException {
        throw new UnsupportedOperationException();
    }

    // whats wrong with you ?
    /*
    public void doesNotCompile() { // METHOD DOES NOT COMPILE
        try {
            mightThrow();
        } catch (FileNotFoundException | IllegalStateException e) {
        } catch (InputMismatchException e | MissingResourceException e) {
        } catch (SQLException | ArrayIndexOutOfBoundsException e) {
        } catch (FileNotFoundException | IllegalArgumentException e) {
        } catch (Exception e) {
        } catch (IOException e) {
        }
    }
    private void mightThrow() throws DateTimeParseException, IOException { }
    */
}

/*
class CannotSwimException extends Exception {
    public CannotSwimException() {
        super();
    }
    public CannotSwimException(Exception e) {
        super(e);
    }
    public CannotSwimException(String message) {
        super(message);
    }
}
*/