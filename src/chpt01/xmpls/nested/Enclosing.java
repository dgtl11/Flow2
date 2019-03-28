// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.3 - Anonymous Inner Classes
 *
 *  Listing: - 1.07.28 - Enclosing.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class Enclosing {

    static class Nested {
        private int price = 6;
    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}