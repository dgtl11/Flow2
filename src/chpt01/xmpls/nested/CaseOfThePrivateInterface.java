// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.1 - Member Inner Classes
 *
 *  Listing: - 1.07.24 - CaseOf.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class CaseOfThePrivateInterface {
    private interface Secret {
        public void shh();
    }
    class DontTell implements Secret {
        public void shh() { }
    }
}