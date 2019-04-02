// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.6 - Additions in Java 8
 *             2.6.5 - Using New Java 8 Map APIs
 *             2.6.5.1 - merge
 *             2.6.5.2 - computeIfPresent and computeIfAbsent
 *
 *  Listing: - 2.6.34 - MethodTesting.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.additions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NewMapAPI {

    public static void main(String[] args) {

        // update the value for a specific key in the map.
        // replace the existing value unconditionally:
        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Jenny", "Tram");
        System.out.println(favorites); // {Jenny=Tram}

        // putIfAbsent(), that you can call if you want to set a
        //value in the map, but this method skips it if the value is already set to a non-null value:
        Map<String, String> favorites2 = new HashMap<>();
        favorites2.put("Jenny", "Bus Tour");
        favorites2.put("Tom", null);

        favorites2.putIfAbsent("Jenny", "Tram");
        favorites2.putIfAbsent("Sam", "Tram");
        favorites2.putIfAbsent("Tom", "Tram");
        System.out.println(favorites);          // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}


        // passing a mapping
        // function to the merge() method:
        BiFunction<String, String, String> mapper = (v1, v2)
        -> v1.length() > v2.length() ? v1: v2;

        Map<String, String> favorites3 = new HashMap<>();
        favorites3.put("Jenny", "Bus Tour");
        favorites3.put("Tom", "Tram");

        String jenny = favorites3.merge("Jenny", "Skyride", mapper);
        String tom = favorites3.merge("Tom", "Skyride", mapper);

        System.out.println(favorites3); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(jenny);      // Bus Tour
        System.out.println(tom);        // Skyride


        // merge() is what happens when the mapping function is
        // called and returns null. The key is removed from the map when this happens:
        BiFunction<String, String, String> mapper2 = (v1, v2) -> null;
        Map<String, String> favorites4 = new HashMap<>();
        favorites4.put("Jenny", "Bus Tour");
        favorites4.put("Tom", "Bus Tour");
        favorites4.merge("Jenny", "Skyride", mapper2);
        favorites4.merge("Sam", "Skyride", mapper2);
        System.out.println(favorites4); // {Tom=Bus Tour, Sam=Skyride}


        // computeIfPresent and computeIfAbsent
        // the upgrade exam but not on the OCP
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapper3 = (k, v) -> v + 1;
        Integer jenny3 = counts.computeIfPresent("Jenny", mapper3);
        Integer sam = counts.computeIfPresent("Sam", mapper3);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jenny3); // 2
        System.out.println(sam);    // null

        // For computeIfAbsent(), the functional interface runs only when the key isn’t present or
        // is null:
        Map<String, Integer> counts4 = new HashMap<>();
        counts4.put("Jenny", 15);
        counts4.put("Tom", null);
        Function<String, Integer> mapper4 = (k) -> 1;
        Integer jenny4 = counts.computeIfAbsent("Jenny", mapper4); // 15
        Integer sam4 = counts.computeIfAbsent("Sam", mapper4); // 1
        Integer tom4 = counts.computeIfAbsent("Tom", mapper4); // 1
        System.out.println(counts4); // {Tom=1, Jenny=15, Sam=1}

        // For computeIfAbsent(), the key is never added to the map in the
        //first place, for example:
        Map<String, Integer> counts5 = new HashMap<>();
        counts5.put("Jenny", 1);
        counts5.computeIfPresent("Jenny", (k, v) -> null);
        counts5.computeIfAbsent("Sam", k -> null);
        System.out.println(counts5); // {}
    }
}

