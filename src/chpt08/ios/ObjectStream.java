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

package chpt08.ios;

import java.io.Console;


public class ObjectStream {

    public static void main(String[] args) {

        String str;

        // the new way
        Console console = System.console();
        if (console == null)
            System.out.println("console not available");

        str = console.readLine("Enter your name: ");
        console.printf("here is your name: %s\n", str);

        System.out.println("Enter the password: ");
        char[] ch = console.readPassword();

        String pass = String.valueOf(ch);
        System.out.println("password is: " + pass);
    }
}