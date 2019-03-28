// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.06 - Working with Enums
 *
 *  Listing: - 1.06.21 - Season3.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.enums;

public enum Season3 {
    WINTER {
        public void printHours() { System.out.println("short hours"); }
    }, SUMMER {
        public void printHours() { System.out.println("long hours"); }
    }, SPRING, FALL;
    public void printHours() { System.out.println("default hours"); }
}