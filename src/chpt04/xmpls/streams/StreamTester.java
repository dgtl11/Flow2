// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.4 - Using Streams
 *             4.4.1 - Creating Stream Sources
 *             4.4.2 - Using Common Terminal Operations
 *             4.4.3 - Intermediate Ops
 *             4.4.4 - Putting togehter the Pipeline
 *             4.4.5 - printing a Stream
 *
 *  Listing: - 4.4.04 - StreamTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.xmpls.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {

        // 01  Creating
        Stream<String> empty = Stream.empty();      // count = 0
        Stream<Integer> singleElement = Stream.of(1);    // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3);  // count = 2



        // from a list to a stream:
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

        // We can’t create
        // an infi nite list, though, which makes streams more powerful:
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ Terminal Ops ~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 02 terminal ops
        // long count()
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count());      // 3

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Optional<T> min(<? super T> comparator)
        // Optional<T> max(<? super T> comparator)
        Stream<String> smo = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = smo.min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println); // ape

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // empty Stream has no minimum
        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());       // false

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Optional<T> findAny()
        // Optional<T> findFirst()
        Stream<String> smo2 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        smo2.findAny().ifPresent(System.out::println); // monkey
        infinite.findAny().ifPresent(System.out::println); // chimp

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // boolean anyMatch(Predicate <? super T> predicate)
        // boolean allMatch(Predicate <? super T> predicate)
        // boolean noneMatch(Predicate <? super T> predicate)
        List<String> listagain = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinity = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(listagain.stream().anyMatch(pred));  // true
        System.out.println(listagain.stream().allMatch(pred));  // false
        System.out.println(listagain.stream().noneMatch(pred)); // false
        System.out.println(infinity.anyMatch(pred));            // true

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // void forEach(Consumer<? super T> action)
        Stream<String> s4each = Stream.of("Monkey", "Gorilla", "Bonobo");
        s4each.forEach(System.out::print);       // MonkeyGorillaBonobo

        // you can’t use a traditional for loop on a stream:
        // Stream s = Stream.of(1);
        // for (Integer i: s) {} // DOES NOT COMPILE

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // T reduce(T identity, BinaryOperator<T> accumulator)
        // Optional<T> reduce(BinaryOperator<T> accumulator)
        // <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        String[] array = new String[] { "w", "o", "l", "f" };
        String result = "";
        for (String sa: array) result = result + sa;
        System.out.println(result);

        // With lambdas, we can do the same thing with a stream
        // and reduction:
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (ss, c) -> ss + c);
        System.out.println(word);                       // wolf

        // We can even rewrite this with a method reference:
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        String word2 = stream2.reduce("", String::concat);
        System.out.println(word2);                       // wolf

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // write a reduction to multiply all of the Integer objects in
        //a stream
        Stream<Integer> stream3 = Stream.of(3, 5, 6);
        System.out.println(stream3.reduce(1, (a, b) -> a*b));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // There are three choices for what
        //is in the Optional
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty2 = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty2.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::print); // 3
        threeElements.reduce(op).ifPresent(System.out::print); // 90

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // This is helpful because it lets us switch to a paral-
        //lel stream easily in the future:
        BinaryOperator<Integer> op4 = (a, b) -> a * b;
        Stream<Integer> stream4 = Stream.of(3, 5, 6);
        System.out.println(stream4.reduce(1, op4, op4)); // 90

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        // <R,A> R collect(Collector<? super T, A,R> collector)
        Stream<String> stream5 = Stream.of("w", "o", "l", "f");
        StringBuilder word5 = stream5.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);

        Stream<String> stream6 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream6.collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set);                        // [f, l, o, w]

        // rewriten
        Stream<String> stream7 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set7 = stream7.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set7);                       // [f, l, o, w]

        // If we didn’t need the set to be sorted, we could make the code even shorter:
        Stream<String> stream8 = Stream.of("w", "o", "l", "f");
        Set<String> set8 = stream8.collect(Collectors.toSet());
        System.out.println(set8);                       // [f, w, l, o]

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~ Intermediate Ops ~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<T> filter(Predicate<? super T> predicate)
        Stream<String> s9 = Stream.of("monkey", "gorilla", "bonobo");
        s9.filter(x -> x.startsWith("m")).forEach(System.out::print);    // monkey

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<T> distinct()
        Stream<String> s10 = Stream.of("duck", "duck", "duck", "goose");
        s10.distinct().forEach(System.out::print); // duckgoose

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<T> limit(int maxSize)
        // Stream<T> skip(int n)
        Stream<Integer> s11 = Stream.iterate(1, n -> n + 1);
        s11.skip(5).limit(2).forEach(System.out::print);          // 67

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        Stream<String> s12 = Stream.of("monkey", "gorilla", "bonobo");

        s12.map(String::length).forEach(System.out::print);   // 676

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(l -> l.stream()).forEach(System.out::println);
        // Bonobo
        //Mama Gorilla
        //Baby Gorilla

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<T> sorted()
        //Stream<T> sorted(Comparator<? super T> comparator)
        Stream<String> s13 = Stream.of("brown-", "bear-");
        s13.sorted().forEach(System.out::print);        // bear-brown-

        System.out.println();

        // we can pass a lambda expression as the comparator. For example, we
        // can pass a Comparator implementation:
        Stream<String> s14 = Stream.of("brown bear-", "grizzly-");
        s14.sorted(Comparator.reverseOrder())
                .forEach(System.out::print);        // grizzly-brown bear-

        // s14.sorted(Comparator::reverseOrder); // DOES NOT COMPILE

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Stream<T> peek(Consumer<? super T> action)
        Stream<String> stream15 = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream15.filter(s15 -> s15.startsWith("g"))
                .peek(System.out::println).count();         // grizzly
        System.out.println(count);                          // 1

        // Danger changing State with peek()
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> stream16 = Stream.of(numbers, letters);
        stream16.map(List::size).forEach(System.out::print);        // 11

        System.out.println();

        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print); // 11
        System.out.println(builder);                                                // [1][a]

        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print);      // 00

        // peek() is modifying the data structure that is used in the
        //stream, which causes the result of the stream pipeline to be different than if the peek
        //wasn’t present

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~ Pipeline  ~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // 04 Pipeline
        List<String> list17 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name: list17) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());
        if (iter.hasNext()) System.out.println(iter.next());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // In Java 8, the equivalent code is as follows:
        List<String> list18 = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        list18.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // or reformat
        list18.stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // infinit loop
        // Stream.generate(() -> "Elsa")
        //        .filter(n -> n.length() == 4)
        //        .sorted()
        //        .limit(2)
        //        .forEach(System.out::println);

        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);

        // another infinit
        // Stream.generate(() -> "Olaf Lazisson")
        //        .filter(n -> n.length() == 4)
        //        .limit(2)
        //        .sorted()
        //        .forEach(System.out::println);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // peeking behind the scenes
        Stream<Integer> infinite20 = Stream.iterate(1, x -> x + 1);
        infinite20.limit(5)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);                 // 135

        System.out.println();

        Stream<Integer> infinite21 = Stream.iterate(1, x -> x + 1);
        infinite21.limit(5)
                .peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);            // 11233455

        System.out.println();

        Stream<Integer> infinite22 = Stream.iterate(1, x -> x + 1);
        infinite22.filter(x -> x % 2 == 1)
                .limit(5)
                .forEach(System.out::print);                // 13579

        System.out.println();

        Stream<Integer> infinite23 = Stream.iterate(1, x -> x + 1);
        infinite23.filter(x -> x % 2 == 1)
                .peek(System.out::print)
                .limit(5)
                .forEach(System.out::print);            // 1133557799

        System.out.println();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // how to print a Stream           works with infinit  | destuct stream
        // s.forEach(System.out::println);             // No               Yes

        // System.out.println(s.collect(Collectors.
        //        toList()));                         // No               Yes

        // s.peek(System.out::println).count();        // No               No

        // s.limit(5).forEach(System.out::println);    // yes              yea



    }
}









