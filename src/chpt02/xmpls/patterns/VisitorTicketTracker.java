// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.1 - applying the singleton pattern
 *                       // Lazy instantiation
 *
 *  Listing: - 2.5.08 - VisitorTicketTracker.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

// Lazy instantiation

public class VisitorTicketTracker {

    private static VisitorTicketTracker instance;
    private VisitorTicketTracker() {
    }
    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker(); // NOT THREAD-SAFE!
        }
        return instance;
    }

    // Data access methods
}

// for threat safety unique singletons:
/*
    public static synchronized VisitorTicketTracker getInstance() {
        if(instance == null) {
            instance = new VisitorTicketTracker();
        }
        return instance;
    }
*/

// for performance double checked locking:
/*
    private static volatile VisitorTicketTracker instance;
    public static VisitorTicketTracker getInstance() {
        if(instance == null) {
            synchronized(VisitorTicketTracker.class) {
                if(instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }
*/