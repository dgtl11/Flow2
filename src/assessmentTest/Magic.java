// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.11 - Magic.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;


import java.util.Optional;
import java.util.stream.Stream;

public class Magic {

    private static void magic(Stream<Integer> s) {

        Optional o = s.filter(x -> x < 5).limit(3).max((x, y) -> x-y);
        System.out.println(o.get());
    }

    public static void main(String[] args) {

    }
}