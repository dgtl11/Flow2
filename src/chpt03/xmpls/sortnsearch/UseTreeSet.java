// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.5 - Searching and Sorting
 *
 *  Listing: - 2.5.31 - UseTreeSet.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.sortnsearch;

import chpt03.xmpls.compare.Duck2;

import java.util.*;

public class UseTreeSet {

    static class Rabbit{ int id; }
    public static void main(String[] args) {
        Set<Duck2> ducks = new TreeSet<>();
        ducks.add(new Duck2("Puddles"));
        Set<Rabbit> rabbit = new TreeSet<>();
        rabbit.add(new Rabbit()); // throws an exception

        // other example
        Set<Rabbit> rabbit2 = new TreeSet<>(new Comparator<Rabbit>() {
            public int compare(Rabbit r1, Rabbit r2) {
                return r1.id = r2.id;
            }
        });
        rabbit2.add(new Rabbit());
    }
}

