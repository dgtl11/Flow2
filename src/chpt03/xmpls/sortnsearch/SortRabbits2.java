// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.5 - Searching and Sorting
 *
 *  Listing: - 2.5.30 - SortRabbits2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.sortnsearch;

import java.util.*;

public class SortRabbits2 {

    static class Rabbit{ int id; }
    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
        // End Main

        // other tricky example
        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c2 = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy", c2);
        System.out.println(index);

    }

}

