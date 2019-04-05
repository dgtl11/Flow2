// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.2 - Built-In Functional Interfaces
 *             4.2.1 - Implementing Supplier
 *
 *  Listing: - 4.2.02 - FunctionalIfaceTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.xmpls.functionaliFaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

// iface abs meths
/*
@FunctionalInterface interface Supplier<T> {
    public T get();
}

@FunctionalInterface interface Consumer<T> {
    void accept(T t);
}
@FunctionalInterface interface BiConsumer<T, U> {
    void accept(T t, U u);
}


@FunctionalInterface interface Predicate<T> {
    boolean test(T t);
}
@FunctionalInterface interface BiPredicate<T, U> {
    boolean test(T t, U u);
}


@FunctionalInterface interface Function<T, R> {
R apply(T t);
}
@FunctionalInterface interface BiFunction<T, U, R> {
R apply(T t, U u);
}

@FunctionalInterface interface UnaryOperator<T>
extends Function<T, T> { }
@FunctionalInterface interface BinaryOperator<T>
extends BiFunction<T, T, T> { }

// signatures look like this
        // T apply(T t);
        // T apply(T t1, T t2);


*/

// you could even make your own if you have to
// with first three supply the types of the three wheel
// speeds. The fourth is the return type
/*
interface TriFunction<T,U,V,R> {
    R apply(T t, U u, V v);
}

// or with 4 or 5
first four supply the types of the four motors.
Ideally these would be the same type, but you never know. The fifth is the return type

interface QuadFunction<T,U,V,W,R> {
R apply(T t, U u, V v, W w);
}

*/

public class FunctionalIfaceTester {
    public static void main(String[] args) {

        // supplier
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        System.out.println(d1);
        System.out.println(d2);

        Supplier<StringBuilder> s12 = StringBuilder::new;
        Supplier<StringBuilder> s22 = () -> new StringBuilder();
        System.out.println(s12.get());
        System.out.println(s22.get());

        Supplier<ArrayList<String>> s13 = ArrayList<String>::new;
        ArrayList<String> a1 = s13.get();
        System.out.println(a1);

        System.out.println();
        System.out.println("#####################################");
        System.out.println();

        // consumer
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Annie");
        c2.accept("Annie");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println(map);

        Map<String, String> map2 = new HashMap<>();
        BiConsumer<String, String> b12 = map2::put;
        BiConsumer<String, String> b22 = (k, v) -> map2.put(k, v);
        b12.accept("chicken", "Cluck");
        b22.accept("chick", "Tweep");
        System.out.println(map2);

        System.out.println();
        System.out.println("#####################################");
        System.out.println();

        // Predicate & BiPredicate
        // how to test a condition
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        // w BiPredicate
        BiPredicate<String, String> b13 = String::startsWith;
        BiPredicate<String, String> b23 = (string, prefix) -> string.startsWith(prefix);
        System.out.println(b13.test("chicken", "chick"));
        System.out.println(b23.test("chicken", "chick"));

        System.out.println();
        System.out.println("#####################################");
        System.out.println();

        // RWS
        // default meth on functional ifaces
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && ! s.contains("brown");

        // better way with the default meths
        Predicate<String> brownEggs2 = egg.and(brown);
        Predicate<String> otherEggs2 = egg.and(brown.negate());

        System.out.println();
        System.out.println("#####################################");
        System.out.println();

        // Function & BiFunction
        // converts a String to the length of the String:
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5

        // combines two String objects and produces another String:
        BiFunction<String, String, String> b14 = String::concat;
        BiFunction<String, String, String> b24 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b14.apply("baby ", "chick")); // baby chick
        System.out.println(b24.apply("baby ", "chick")); // baby chick

        System.out.println();
        System.out.println("#####################################");
        System.out.println();

        // UnaryOperator & BinaryOperator
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        BinaryOperator<String> b15 = String::concat;
        BinaryOperator<String> b25 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b15.apply("baby ", "chick")); // baby chick
        System.out.println(b25.apply("baby ", "chick")); // baby chick


        System.out.println();
        System.out.println("#####################################");
        System.out.println();


        // checking foo
        /*  What to use ??
        _____<List> ex1 = x -> "".equals(x.get(0));
        _____<Long> ex2 = (Long l) -> System.out.println(l);
        _____ <String, String> ex3 = (s1, s2) -> false;
        */
        Predicate <List> ex1 = x -> "".equals(x.get(0));
        Consumer <Long> ex2 = (Long l) -> System.out.println(l);
        // BiPredicate <String, String> ex3 = (s1, s2) -> false;

        // what doesn't work
        // Function<List<String>> ex1 = x -> x.get(0);  // DOES NOT COMPILE
        // UnaryOperator<Long> ex22 = (Long l) -> 3.14; // DOES NOT COMIPLE
        // Predicate ex4 = String::isEmpty;             // DOES NOT COMPILE

    }
}