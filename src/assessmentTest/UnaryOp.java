// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.20 - UnaryOp.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.time.LocalDate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class UnaryOp {
    public static void main(String[] args) {
        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = l -> l;
        s.filter(l -> l != null).map(u).peek(System.out::println);
    }
}