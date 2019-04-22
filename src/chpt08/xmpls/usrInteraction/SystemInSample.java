// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.4 - userinteraction
 *
 *  Listing: - 08.4.09 - SystemInSample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.usrInteraction;

import java.io.*;



public class SystemInSample {

    public static void main(String[] args) throws IOException {

        // the old way
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userInput = reader.readLine();
        System.out.println("You entered the following: " + userInput);
    }
}