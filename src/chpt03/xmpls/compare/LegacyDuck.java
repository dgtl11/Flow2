// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.1 - Comparable
 *
 *  Listing: - 2.4.23 - LegacyDuck.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;

public class LegacyDuck implements Comparable<LegacyDuck> {

    private String name;
    // public int compareTo(Object obj) {  // old code doesn't work that way anymonre
    public int compareTo(LegacyDuck obj) {
        LegacyDuck d = (LegacyDuck) obj; // cast because no generics
        return name.compareTo(d.name);
    }

}

