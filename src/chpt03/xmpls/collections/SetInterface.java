// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.3 - Using Lists, Sets, Maps, and Queues
 *             2.3.3 - Using the Set Interface
 *
 *  Listing: - 2.3.18 - SetInterface.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.collections;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterface {

    public static void main(String[] args) {

        // HashSet
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66); // true
        boolean b2 = set.add(10); // true
        boolean b3 = set.add(66); // false
        boolean b4 = set.add(8); // true
        for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,


        // TreeSet:
        Set<Integer> set2 = new HashSet<>();
        boolean b5 = set2.add(66); // true
        boolean b6 = set2.add(10); // true
        boolean b7 = set2.add(66); // false
        boolean b8 = set2.add(8); // true
        for (Integer integer: set2) System.out.print(integer + ","); // 8,10,66


        // J6 Methods
        NavigableSet<Integer> set3 = new TreeSet<>();
        for (int i = 1; i <= 20; i++) set3.add(i);
        System.out.println(set3.lower(10)); // 9
        System.out.println(set3.floor(10)); // 10
        System.out.println(set3.ceiling(20)); // 20
        System.out.println(set3.higher(20)); // null
    }

}

