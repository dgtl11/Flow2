// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.18 - r09CheetahManager.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

// make it singleton

public class r09CheetahManager {
    private static r09CheetahManager cheetahManager;     // Change the access modifier of cheetahManager from public to private. IntelliJ tells to
    private r09CheetahManager() {}
    public static synchronized r09CheetahManager getCheetahManager() { // Add synchronized to getCheetahManager().
        if(cheetahManager == null) {
            cheetahManager = new r09CheetahManager();
        }
        return cheetahManager;
    }
}