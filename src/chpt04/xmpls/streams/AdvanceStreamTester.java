// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.6 - Working with advanced Stream pipeline concepts
 *             4.6.1 - Linkin Streams to the underlying data
 *             4.6.2 - chaining optionals
 *             4.6.3 - collecting results
 *
 *  Listing: - 4.6.06 - AdvanceStreamTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.xmpls.streams;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// import static java.util.stream.Collectors.*;

public class AdvanceStreamTester {

    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~ linking ~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        List<String> cats1 = new ArrayList<>();
        cats1.add("Annie");
        cats1.add("Ripley");
        Stream<String> stream1 = cats1.stream();
        cats1.add("KC");
        System.out.println(stream1.count());


        // we wanted to get an Optional<Integer> representing the length of
        // the String contained in another Optional . Easy enough:
        // Optional<Integer> result = optional.map(String::length);

        // Optional<Integer> result = optional.flatMap(ChainingOptionals::calculator);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~ collecting ~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        String result = ohMy1.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double result2 = ohMy2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); // 5.333333333333333

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        // TreeSet<String> result3 = ohMy3.filter(s -> s.startsWith("t")
        //        .collect(Collectors.toCollection(TreeSet::new));
        // System.out.println(result3); // [tigers]

        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy4.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        // Map<Integer, String> map5 = ohMy5.collect(Collectors.toMap(String::length, k -> k)); // BAD

        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map6 = ohMy6.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map6); // {5=lions,bears, 6=tigers}
        System.out.println(map6.getClass()); // class. java.util.HashMap

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy7 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map7 = ohMy7.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map7); // // {5=lions,bears, 6=tigers}
        System.out.println(map7.getClass()); // class. java.util.TreeMap

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // grouping partitioning and mapping
        Stream<String> ohMy8 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map8 = ohMy8.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map8); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy9 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map9 = ohMy9.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map9); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy10 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map10 = ohMy10.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map10); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy11 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map11 = ohMy11.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map11);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy12 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map12 = ohMy12.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map12); // {false=[tigers], true=[lions, bears]}

        Stream<String> ohMy13 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map13 = ohMy13.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map13); // {false=[], true=[lions, tigers, bears]}

        Stream<String> ohMy14 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map14 = ohMy14.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map14); // {false=[], true=[lions, tigers, bears]}

        Stream<String> ohMy15 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map15 = ohMy15.collect(
                Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map15);// {false=[], true=[lions, tigers, bears]}

        Stream<String> ohMy16 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map16 = ohMy16.collect(Collectors.groupingBy(
                String::length, Collectors.counting()));
        System.out.println(map16); // {5=2, 6=1}

        /* Stream<String> ohMy17 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map17 = ohMy17.collect(
                groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.charAt(0),
                                Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(map17); // {5=Optional[b], 6=Optional[t]}
*/
        // Stream<String> ohMy18 = Stream.of("lions", "tigers", "bears");
        // Map<Integer, Optional<Character>> map18 = ohMy18.collect(
        //        groupingBy(
        //                String::length,
        //                mapping(s -> s.charAt(0),
        //                        minBy(Comparator.naturalOrder()))));
        // System.out.println(map18); // {5=Optional[b], 6=Optional[t]}


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
/*
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~ chaining ~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
*/
    // chaining optionals
    private static void threeDigit1(Optional<Integer> optional) {
        if (optional.isPresent()) {     // outer if
            Integer num = optional.get();
            String string = "" + num;
            if (string.length() == 3)   // inner if
                System.out.println(string);
        }
    }

    // It works, but it contains nested if statements. That’s extra complexity

    private static void threeDigit2(Optional<Integer> optional) {
        optional.map(n -> "" + n)                   // part 1
                .filter(s -> s.length() == 3)       // part 2
                .ifPresent(System.out::println);    // part 3

    }


}









