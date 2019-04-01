// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.4 - interacting with Legacy Code
 *
 *  Listing: - 2.2.11 - LegacyAutoboxing.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;

public class LegacyAutoboxing {

    public static void main(String[] args) {
        java.util.List numbers = new java.util.ArrayList();
        numbers.add(5);
        // int result = numbers.get(0); // DOES NOT COMPILE
    }
}

