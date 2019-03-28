// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.06 - Working with Enums
 *
 *  Listing: - 1.06.19 - OnlyOne.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.enums;

public enum OnlyOne {
    ONCE (true);
    private OnlyOne(boolean b) {
        System. out .println("constructing");
    }
    public static void main(String[] args) {
        OnlyOne firstCall = OnlyOne. ONCE ; // prints constructing
        OnlyOne secondCall = OnlyOne. ONCE ; // doesn't print anything
    }
}