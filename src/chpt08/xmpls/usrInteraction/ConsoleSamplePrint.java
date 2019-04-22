// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.4 - userinteraction
 *
 *  Listing: - 08.4.11 - ConsoleSamplePrint.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.usrInteraction;

import java.io.Console;
import java.io.IOException;

// syntax:
// Console console = System.console();
// console.writer().format(new Locale("fr", "CA"),"Hello World");

public class ConsoleSamplePrint {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Console console = System.console();
        if(console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to Our Zoo!");
            console.format("Our zoo has 391 animals and employs 25 people.");
            console.writer().println();
            console.printf("The zoo spans 128.91 acres.");
        }
    }
}