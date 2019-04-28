// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.18 - ParalStreamTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.parallel;


import java.util.Arrays;
import java.util.stream.Stream;

public class ParalStreamTester {

    public static void main(String[] args) {

        // parallel()
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        Stream<Integer> parallelStream = stream.parallel();

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


    }
}
