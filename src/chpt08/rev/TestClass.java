// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.8 -
 *
 *  Listing: - 08.8.16 - TestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.rev;

import java.io.Console;

public class TestClass {
    public static void main(String[] args) {

        Console c = System.console();
        char[] cha = c.readPassword("Please enter password: ");
        String pwd = new String(cha);
        System.out.println("pwd = " + pwd);
        
    }
}