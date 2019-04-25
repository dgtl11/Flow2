// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.4 - userinteraction
 *
 *  Listing: - 08.4.10 - ConsoleDemo.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.ios;

import java.io.Console;

// try @ home on linux

public class ConsoleDemo {

    public static void main(String[] args) {
        String name = "";
        Console c = System.console();

        if (c == null)
            System.out.println("console not available");

        char[] pw;
        pw= c.readPassword("%s", "pw: ");

        for(char ch: pw)
            c.format("%c", ch);
        c.format("\n");

        MyUtility mu = new MyUtility();
        while(true) {
            name = c.readLine("%s", "input?: ");
            c.format("output: %s \n", mu.doStuff(name));
        }
    }
}

class MyUtility {
    String doStuff(String arg1) {
        return "result is " + arg1;
    }
}