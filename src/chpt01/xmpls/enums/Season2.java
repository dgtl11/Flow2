// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.06 - Working with Enums
 *
 *  Listing: - 1.06.20 - Season2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.enums;

public enum Season2 {
    WINTER {
        public void printHours() { System. out .println("9am-3pm"); }
    }, SPRING {
        public void printHours() { System. out .println("9am-5pm"); }
    }, SUMMER {
        public void printHours() { System. out .println("9am-7pm"); }
    }, FALL {
        public void printHours() { System. out .println("9am-5pm"); }
    };
    public abstract void printHours();
}