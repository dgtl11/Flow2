// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.x - AnwendungsBeispiel
 *
 *  Listing: - 3.x.11 - ReductionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReductionTest {
    
    public static void main(String[] args) {
        
        Stream<String> str = Stream.of("H","a","l","l","o");

        // immutable Reduction
        // System.out.println(str.reduce("", (a, b) -> a + b));

        // Mutable Reduction
        // StringBuilder erg = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // TreeSet<String> erg = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        // ArrayList<String> erg = str.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        // List<String> erg = str.collect(Collectors.toList());
        // Set<String> erg = str.collect(Collectors.toSet());
        Collection<String> erg = str.collect(Collectors.toCollection(HashSet::new));

        System.out.println(erg);
    }
}
