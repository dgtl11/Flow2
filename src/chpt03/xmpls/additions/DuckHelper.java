// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.6 - Additions in Java 8
 *             2.6.1 - Using Method References
 *
 *  Listing: - 2.5.32 - DuckHelper.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.additions;


import chpt03.xmpls.compare.Duck2;

public class DuckHelper {

    public static int compareByWeight(Duck2 d1, Duck2 d2) {
        return d1.getWeight()-d2.getWeight();
    }
    public static int compareByName(Duck2 d1, Duck2 d2) {
        return d1.getName().compareTo(d2.getName());
    }
}

