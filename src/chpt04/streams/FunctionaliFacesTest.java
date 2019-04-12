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

import java.util.IntSummaryStatistics;
import java.util.function.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FunctionaliFacesTest {

    public static void main(String[] args) {

        Predicate<String> p1;
        BiPredicate<String, String> p2;

        // eingang: String, retrun: String
        UnaryOperator<String> uo1;
        // eingang: String & String, return: string
        BinaryOperator<String> bo2;

        // eingang: Integer, return: String
        Function<Integer, String> f1;
        // eingang: Integer & Integer, return: String
        BiFunction<Integer, Integer, String> f2;

        // eingang: String, return: void
        Consumer<String> c1;

        // eingang: 2x String, return: void
        BiConsumer<String, String> c2;

        // eingang: nichts, return: String
        Supplier<String> s1;

        // erzeugt primitive ints
        IntSupplier is1;

        // verbraucht primitive ints
        IntConsumer ic;

        // eingang: String und long, return: void
        ObjLongConsumer<String> objc;

        // eingang: String, return: double
        ToDoubleFunction<String> tdf;

        // eingang: long, return: int
        LongToDoubleFunction lti;


    }

}

