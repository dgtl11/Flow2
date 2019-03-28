// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.36 - Outer.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;


public class Outer {
    class Inner {}

    public static void main(String[] args) {
        // insert code here
        // Inner in = new Inner();
        // Inner in = Outer.new Inner();
        // Outer.Inner in = new Outer.Inner();
        // Outer.Inner in = new Outer().Inner();
        Outer.Inner in = new Outer().new Inner();       // only E
        // Outer.Inner in = Outer.new Inner();

    }
}

