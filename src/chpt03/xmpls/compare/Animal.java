// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.1 - Comparable
 *
 *  Listing: - 2.4.22 - Animal.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;

import java.util.*;

public class Animal implements Comparable<Animal> {

    private int id;
    public int compareTo(Animal a) {
        return id - a.id;
    }
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}

