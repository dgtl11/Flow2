// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.5 - Searching and Sorting
 *
 *  Listing: - 2.5.29 - SortRabbits.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.sortnsearch;

import java.util.*;

public class SortRabbits {

    static class Rabbit{ int id; }
    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        // Collections.sort(rabbits); // DOES NOT COMPILE
    }

}

