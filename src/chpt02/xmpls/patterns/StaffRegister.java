// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.1 - applying the singleton pattern
 *
 *  Listing: - 2.5.07 - StaffRegister.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;


public class StaffRegister {
    private static final StaffRegister instance;
    static {
        instance = new StaffRegister();
        // Perform additional steps
    }
    private StaffRegister() {
    }
    public static StaffRegister getInstance() {
        return instance;
    }

    // Data access methods

}