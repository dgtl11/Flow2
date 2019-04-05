// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.15 - MapTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.collections;

import java.util.*;
import java.util.Map.Entry;


public class MapTest {
    public static void main(String[] args) {

        // Map<String, String> m1 = new HashMap<>();
        Map<String, String> m1 = new LinkedHashMap<>();  // Einfüge Reihenfolge , bezogen auf Key
        // Map<String, String> m1 = new TreeMap<>();       // da geht null nicht

        m1.put("vorname", "Peter");
        m1.put("nachname", "parker");

        m1.put("nachname", "kent");
        m1.put(null, "nix");         // nicht in TreeMap

        System.out.println(m1.get("nachname"));
        System.out.println(m1.get(null));       // nicht in TreeMap

        for(String s : m1.keySet()) {
            System.out.println(s);
        }

        System.out.println("-------------");
        for(Entry<String, String> e : m1.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        System.out.println("-------------");

        NavigableMap<String, Integer> m2 = new TreeMap<>();
        m2.put("Z", 200);
        m2.put("A", 300);
        m2.put("B", 500);
        m2.put("H", 700);
        m2.put("S", 900);
        m2.put("P", 100);

        System.out.printf("Key set : %s%n", m2.keySet());
        System.out.printf("desc set : %s%n", m2.descendingKeySet());

        System.out.printf("Floor : %s%n", m2.floorEntry("L"));
        System.out.printf("Floor : %s%n", m2.ceilingEntry("L"));

        System.out.println("-------------");

        Map<Test2, Integer> m3 = new HashMap<>();
        m3.put(new Test2(), 100);
        m3.put(new Test2(), 200);
        m3.put(new Test2(), 300);

        System.out.println(m3);

    }
}

class Test2 {
    @Override
    public int hashCode() {
        return 1;
    }
    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }
}