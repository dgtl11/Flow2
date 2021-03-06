// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.60 - ParalStreamTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.parallel;


import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParalStreamTester {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,5,7,4,3,22,78,99,13));

        System.out.println(ints);

        Consumer<Integer> cons = e -> System.out.print(e + ", ");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ints.stream().parallel().forEach(cons);
        System.out.println();

        // ints.parallelStream().sequential().forEach(cons);
        ints.parallelStream().map(e->e+1).forEachOrdered(cons);

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ints.stream().filter(e-> e > 10 ).forEach(cons);
        System.out.println();
        ints.parallelStream().filter(e -> e > 10).forEach(cons);

        System.out.println("\n~~~~~~~~~~~~~~~ Order based ~~~~~~~~~");

        ints.stream().limit(4 ).forEach(cons);
        System.out.println();
        ints.parallelStream().unordered().limit(4).forEach(cons);

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ints.stream().skip(4 ).forEach(cons);
        System.out.println();
        ints.parallelStream().unordered().skip(4).forEach(cons);

        // findFirst is also order based

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Consumer<String> stringConsumer = e -> System.out.print(e + ", ");

        List<String> list = Collections.synchronizedList( new ArrayList<>());

        Arrays.asList("Peter", "Clark", "Bruce", "Dani")
                .parallelStream()
                .map(e -> { list.add(e);return e;})
                .forEach(stringConsumer);

        System.out.println(list);

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Object[] arr =
        Arrays.asList("Peter", "Clark", "Bruce", "Dani")
                .parallelStream()
                .toArray();

        for(Object o : arr)
            System.out.println(o);

        // orderBased Ops
        // skip(), limit(), findFirst(), toArray()

        System.out.println("\n~~~~~~~~~~ Buch Xmpls ~~~~~~~~~~~~~~");
/*
        // parallel()
        Stream<Integer> stream1 = Arrays.asList(1,2,3,4,5,6).stream();
        Stream<Integer> parallelStream = stream1.parallel();

        // parallelStream()
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();

        // Processing Tasks in Parallel
        Arrays.asList(1,2,3,4,5,6)
                .stream()
                .forEach(s -> System.out.print(s+" "));

        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEach(s -> System.out.print(s+" "));

        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s+" "));

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // independend Operations
        Arrays.asList("jackal","kangaroo","lemur")
                .parallelStream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Arrays.asList("jackal","kangaroo","lemur")
                .parallelStream()
                .map(s -> {System.out.println(s); return s.toUpperCase();})
                .forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // avoid stateful Operations
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        Arrays.asList(1,2,3,4,5,6).parallelStream()
                .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i+" "));

        System.out.println();
        for(Integer e: data) {
            System.out.print(e+" ");

        }
        // Note that this would not have been noticeable with a serial stream

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());

        // output could be 4, 1, or really any value in the stream

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // will not be on exam
        Arrays.asList(1,2,3,4,5,6).stream().unordered();

        Arrays.asList(1,2,3,4,5,6).stream().unordered().parallel();

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // reduce()
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> (a-b))); // NOT AN ASSOCIATIVE ACCUMULATOR

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(Arrays.asList("w","o","l","f")
                .parallelStream()
                .reduce("X",String::concat));

        // can output XwXoXlXf

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // collect()
        Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set2 = stream2.collect(ConcurrentSkipListSet::new, Set::add,
                Set::addAll);
        System.out.println(set2); // [f, l, o, w]

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> stream3 = Stream.of("w", "o", "l", "f").parallel();
        Set<String> set3 = stream3.collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map1 = ohMy1
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map1);                    // {5=lions,bears, 6=tigers}
        System.out.println(map1.getClass());         // java.util.concurrent.ConcurrentHashMap

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // groupingBy()
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map2 = ohMy2.collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
*/
    }
}
