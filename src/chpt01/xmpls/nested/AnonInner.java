// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.3 - Anonymous Inner Classes
 *
 *  Listing: - 1.07.26 - AnonInner.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class AnonInner {

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }
    /* also possible with interface
    interface SaleTodayOnly {
        int dollarsOff();
    }
     */

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() { return 3; }
        };
        return basePrice - sale.dollarsOff();
    }


}