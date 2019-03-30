// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.1 - applying the singleton pattern
 *
 *  Listing: - 2.5.05 - HayStorage.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;


public class HayStorage {
    private int quantity = 0;
    private HayStorage() {}

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }
    public synchronized void addHay(int amount) {
        quantity += amount;
    }
    public synchronized boolean removeHay (int amount) {
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity() {
        return quantity;
    }
}