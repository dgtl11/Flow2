// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.5 - Bounds
 *                   - Upper-Bounded Wildcards
 *
 *  Listing: - 2.2.13 - UpperBoundries.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


import java.util.ArrayList;
import java.util.List;

public class UpperBoundries {

    // ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
    // Instead, we need to use a wildcard:

    List<? extends Number> list = new ArrayList<Integer>();

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }

    // Java converts the previous code to something
    // equivalent to the following:
    /*
    public static long total(List list) {
        long count = 0;
        for (Object obj: list) {
            Number number = (Number) obj;
            count += number.longValue();
        }
        return count;
    }
    */

    static class Sparrow extends Bird { }
    static class Bird { }

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<Bird>();
        // birds.add(new Sparrow()); // DOES NOT COMPILE
        // birds.add(new Bird()); // DOES NOT COMPILE
    }

}

