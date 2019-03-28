// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.05 - Coding equals, hashCode, toString
 *
 *  Listing: - 1.05.14 - Equalses.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.coding;

public class Equalses {

    public static void main(String[] args) {

        String s1 = new String("lion");
        String s2 = new String("lion");
        System.out.println(s1.equals(s2));          // true
        StringBuilder sb1 = new StringBuilder("lion");
        StringBuilder sb2 = new StringBuilder("lion");
        System.out.println(sb1.equals(sb2));        // false
    }
}