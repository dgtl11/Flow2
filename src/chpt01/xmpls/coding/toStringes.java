// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.05 - Coding equals, hashCode, toString
 *
 *  Listing: - 1.05.12 - toStringes.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.coding;

import java.util.ArrayList;

public class toStringes {
    public static void main(String[] args) {

        System.out.println(new ArrayList());    // []
        System.out.println(new String[0]);      // [Ljava.lang.String;@65cc892e
    }
}