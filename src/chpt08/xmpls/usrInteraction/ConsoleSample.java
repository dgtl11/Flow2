// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.4 - userinteraction
 *
 *  Listing: - 08.4.10 - ConsoleSample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.usrInteraction;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleSample {

    public static void main(String[] args) {

        // the new way
        Console console = System.console();
        if(console != null) {
            String userInput = console.readLine();
            console.writer().println ("You entered the following: "+userInput);
        }
    }
}