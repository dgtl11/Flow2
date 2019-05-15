// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.66 - StreamTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.parallel;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTester {

    public static void main(String[] args) {

        Stream<String> ints = Stream.of(1,2,3,4,5)
                .map(w -> w + "");
        System.out.println(ints.isParallel());

        String[] worte = "Das ist ein Haus von NickiGraus".split(" ");
        boolean b = Arrays.stream(worte)
                .flatMap(w -> Arrays.stream(w.split("")).parallel())    // in here parallel / isParallel = true
                .isParallel();                                                // ausgabe ist aber nicht / isParallel = false
                // .forEach(System.out::print);                               // flatMap klopft so flach das ergebnisse alle serial sind

        System.out.println(b);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Stream<String> satz1 = Stream.of("Das", "ist", "ein").parallel();
        Stream<String> satz2 = Stream.of("Haus", "von", "NikiGraus").parallel();
        Stream<Stream<String>> ganzerSatz = Stream.of(satz1, satz2);

        ganzerSatz.flatMap(w -> w).forEach(System.out::print);

    }
}
