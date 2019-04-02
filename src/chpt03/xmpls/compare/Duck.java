// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.1 - Comparable
 *
 *  Listing: - 2.4.21 - Duck.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;

import java.util.*;

public class Duck implements Comparable<Duck> {

    private String name;
    public Duck(String name) {
        this.name = name;
    }
    public String toString() { // use readable output
        return name;
    }
    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name); // call String's compareTo
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks);            // sort by name
        System.out.println(ducks);          // [Puddles, Quack]
    }
}

