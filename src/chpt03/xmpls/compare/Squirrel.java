// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.2 - Comparator       // ble -> tor
 *
 *  Listing: - 2.4.26 - Squirrel.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;


public class Squirrel {

    private int weight;
    private String species;
    public Squirrel(String theSpecies) {
        if (theSpecies == null) throw new IllegalArgumentException();
        species = theSpecies;
    }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public String getSpecies() { return species; }

}

