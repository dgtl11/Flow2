// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.3 - Using Lists, Sets, Maps, and Queues
 *             2.3.1 - Common Collections Methods
 *
 *  Listing: - 2.3.16 - CllctnMthds.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.collections;

import java.util.*;

public class CllctnMthds {

    public static void main(String[] args) {

        // add()
        // boolean add(E element)

        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow")); // true
        System.out.println(list.add("Sparrow")); // true

        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); // true
        System.out.println(set.add("Sparrow")); // false



        // remomve()
        // boolean remove(Object object)
        List<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // prints false
        System.out.println(birds.remove("hawk")); // prints true
        System.out.println(birds); // [hawk]



        // isEmpty() and size()
        // boolean isEmpty()
        // int size()
        System.out.println(birds.isEmpty()); // true
        System.out.println(birds.size());    // 0
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk]
        System.out.println(birds.isEmpty()); // false
        System.out.println(birds.size()); // 2


        // clear()
        // void clear()
        List<String> birds2 = new ArrayList<>();
        birds2.add("hawk"); // [hawk]
        birds2.add("hawk"); // [hawk, hawk]
        System.out.println(birds2.isEmpty()); // false
        System.out.println(birds2.size()); // 2
        birds2.clear(); // []
        System.out.println(birds2.isEmpty()); // true
        System.out.println(birds2.size()); // 0


        // contains()
        // boolean contains(Object object)
        List<String> birds3 = new ArrayList<>();
        birds3.add("hawk"); // [hawk]
        System.out.println(birds3.contains("hawk")); // true
        System.out.println(birds3.contains("robin")); // false




    }



}

