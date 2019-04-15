// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Streams
 *
 *    Thema: - 4.x - AnwendungsBeispiel
 *
 *  Listing: - 4.x.13 - FunctionaliFacesTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.streams;

import assessmentTest.UnaryOp;

import java.awt.*;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Random;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FunctionaliFacesTest {

    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String, return: boolean
        // Predicate<String> p1;
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // takes: 2x String, return: boolean
        // BiPredicate<String, String> bp2;
        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

        BiPredicate<String, String> bp1 = (a,b) -> a.concat(b).length() > 10;

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String, retrun: String
        // UnaryOperator<String> uo1;
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        UnaryOperator<String> bop2 = s -> s.trim().toUpperCase();

        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String & String, return: string
        // BinaryOperator<String> bo2;
        BinaryOperator<String> bo1 = String::concat;
        BinaryOperator<String> bo2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(bo1.apply("baby ", "chick")); // baby chick
        System.out.println(bo2.apply("baby ", "chick")); // baby chick

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: Integer, return: String
        // Function<Integer, String> f1;
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        Function<Integer, String> f3 = a -> a + "";

        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: Integer & Integer, return: String
        // BiFunction<Integer, Integer, String> f2;
        BiFunction<String, String, String> bf1 = String::concat;
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);

        BiFunction<Integer, Integer, String> bf3 = (a,b) -> a + " " + b;

        System.out.println(bf1.apply("baby ", "chick")); // baby chick
        System.out.println(bf2.apply("baby ", "chick")); // baby chick

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String, return: void
        // Consumer<String> c1;
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie");
        c2.accept("Annie");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: 2x String, return: void
        // BiConsumer<String, String> bc2;
        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> bc1 = map::put;
        BiConsumer<String, Integer> bc2 = (k, v) -> map.put(k, v);

        bc1.accept("chicken", 7);
        bc2.accept("chick", 1);

        BiConsumer<String, String> bc3 = (a,b) -> System.out.println(a + b);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: nichts, return: String
        // Supplier<String> s1;
        Supplier<String> s1 = String::new ;
        Supplier<String> s2 = () -> new String();

        System.out.println(s1.get());
        System.out.println(s2.get());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // erzeugt primitive ints
        // IntSupplier is1;
        IntSupplier is1 = () -> new Integer(10);
        IntSupplier is2 = () -> new Random().nextInt(100);

        System.out.println(is1.getAsInt());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // verbraucht primitive ints
        // IntConsumer ic;
        IntConsumer ic = x -> System.out.println(x);
        IntConsumer ic2 = (i) -> {
            return;
        };

        ic.accept(20);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String und long, return: void
        // ObjLongConsumer<String> objc;
        ObjLongConsumer<String> objc = (x, y) -> System.out.println(x);

        objc.accept("Honey",22);

        ObjLongConsumer<String> objc2 = (str, l) -> System.out.println(str + l);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: String, return: double
        // ToDoubleFunction<String> tdf;
        ToDoubleFunction<String> tdf = x -> x.length();

        tdf.applyAsDouble("Linus");

        ToDoubleFunction<String> tdf2 = (str) -> ((Integer) str.length()).doubleValue();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // eingang: long, return: int
        // LongToDoubleFunction ltd;
        LongToDoubleFunction ltd = x -> x ;
        ltd.applyAsDouble(44);

        LongToDoubleFunction lti = (l) -> ((Long)l).intValue();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // shift operator    byte verschiebung
        int i = 65;             //   1000001
        int y = i << 2;
        System.out.println(y);  // 100000100

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // BinaryOperator<Integer> = (Integer x, Integer y) -> y +=x;
        // BinaryOperator<Integer> = Integer::rotateLeft;


        Stream<Integer> stream = IntStream.range(1, 100).boxed();
        stream = stream.map((i2) -> {
            System.out.println(i2);
            return i2 + 1;
        });

        stream.forEach(System.out::println);




    }

}

