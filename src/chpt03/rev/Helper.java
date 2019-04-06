// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.56 - Helper.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;


import java.io.FileNotFoundException;

public class Helper {

    public static <U extends Exception> void printException(U u) {
        System.out.println(u.getMessage());
    }
    public static void main(String[] args) {
        Helper.printException(new FileNotFoundException("A"));
        Helper.printException(new Exception("B"));
        // Helper.<Throwable>printException(new Exception("C"));
        Helper.<NullPointerException>printException(new NullPointerException("D"));
        // Helper.printException(new Throwable("E"));
    } }


