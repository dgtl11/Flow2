// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.14 - Compile.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;


import java.io.RandomAccessFile;
import java.util.Scanner;

public class Compiles {
    private static class RainException extends Exception {
    }

    public static void main(String[] args) throws RainException {
        try (Scanner s = new Scanner("rain")) {
            // try (String line = "") {
                if (s.nextLine().equals("rain"))
                    throw new RainException();
            // }
        } finally {
            RandomAccessFile s = null;
            // s.close();
        }
    }
}