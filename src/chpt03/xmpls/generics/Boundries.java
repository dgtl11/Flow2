// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.5 - Bounds
 *                   - Unbounded Wildcards
 *
 *  Listing: - 2.2.12 - Boundries.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;

import java.util.ArrayList;
import java.util.List;

public class Boundries {

    // public static void printList(List<Object> list) {
    //    for (Object x: list) System.out.println(x);
    // }
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        // printList(keywords); // DOES NOT COMPILE
        // Wait. What’s wrong? A String is a subclass of an Object. This is true. However,
        // List<String> cannot be assigned to List<Object>.

        // if that would work we could write code like this
        List<Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(42));
        // List<Object> objects = numbers; // DOES NOT COMPILE
        // objects.add("forty two");
        // System.out.println(numbers.get(1));

        // storing the wrong objects - Array vs. ArrayLists
        Integer[] numbers2 = { new Integer(42)};
        Object[] objects = numbers2;
        objects[0] = "forty two";   // throws ArrayStoreException

        // back to ... this code does what we expect
        List<String> keywords2 = new ArrayList<>();
        keywords2.add("java");
        printList(keywords2);
    }

    public static void printList(List<?> list) {
        for (Object x: list) System.out.println(x);
    }
}

