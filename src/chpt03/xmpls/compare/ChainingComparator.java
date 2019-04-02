// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.2 - Comparator       // ble -> tor
 *
 *  Listing: - 2.4.28 - ChainingComparator.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;


import java.util.Comparator;

public class ChainingComparator implements Comparator<Squirrel> {

    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1, s2);
    }

}

