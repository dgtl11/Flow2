// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.13 - TC13.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;


import java.io.Console;

public class TC13 {

    public static void main(String [] args) {
        String line;
        Console c = System.console();
        if ((line = c.readLine()) != null)
            System.out.println(line);
    }
}