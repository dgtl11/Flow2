// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Streams
 *
 *    Thema: - 4.x - AnwendungsBeispiel
 *
 *  Listing: - 4.x.12 - PrimitiveStreamsTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.streams;

import java.util.*;
import java.util.function.LongToDoubleFunction;
import java.util.stream.*;

public class PrimitiveStreamsTest {

    public static void main(String[] args) {

        IntStream iStream  = IntStream.of(1,10,22,30,17,5);

        DoubleStream dStream = DoubleStream.of(1,10,22,30,17,5);

        LongStream lStream = LongStream.of(1,10,22,30,17,5);

        // Stream<Double> d = Stream.of(1,10,22,30,17,5);
        // double d = 10;   // widening
        // Double d2 = 10; // Integer boxt zuerst -> boxen widening

        // iStream.boxed().mapToDouble((i) -> i * 1.0);        // erst boxen mit boxed
                                                            // dann auto unboxing to calc
                                                            // dann widening weil multiplic mit double == double

        // System.out.println(lStream.max());              // bei primitiven braucht man keinen comparator
        // System.out.println(lStream.min());

        IntSummaryStatistics summary = iStream.summaryStatistics();
        System.out.println("max: " + summary.getMax());
        System.out.println("min: " + summary.getMin());
        System.out.println("avg: " + summary.getAverage());

    }

}

