// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.4 - Comparator vs. Comparable
 *             2.4.2 - Comparator       // ble -> tor
 *
 *  Listing: - 2.4.25 - Duck2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Duck2 implements Comparable<Duck2> {

    private String name;
    private int weight;
    public Duck2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Duck2(String puddles) {
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String toString() { return name; }
    public int compareTo(Duck2 d) {
        return name.compareTo(d.name);
    }

    public static void main(String[] args) {
        Comparator<Duck2> byWeight = new Comparator<Duck2>() {
            public int compare(Duck2 d1, Duck2 d2) {
                return d1.getWeight()-d2.getWeight();
            }
        };
        List<Duck2> ducks = new ArrayList<>();
        ducks.add(new Duck2("Quack", 7));
        ducks.add(new Duck2("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]
        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
        // End Main

        // other examples
        Comparator<Duck2> byWeight2 = (d1, d2) -> d1.getWeight()-d2.getWeight();
        Comparator<Duck2> byWeight3 = (Duck2 d1, Duck2 d2) -> d1.getWeight()-d2.getWeight();
        Comparator<Duck2> byWeight4 = (d1, d2) -> { return d1.getWeight()-d2.getWeight(); };
        Comparator<Duck2> byWeight5 = (Duck2 d1, Duck2 d2) -> {return d1.getWeight()- d2.getWeight(); };



    }

}

