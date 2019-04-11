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

import java.util.stream.Stream;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author tlubowiecki
 */
public class ReductionTest {

    public static void main(String[] args) {

        Stream<String> str = Stream.of("H", "A", "L", "L", "O", "!!", "ae", "123", "abc");

        // Immutable Reduction
        // System.out.println(str.reduce("", (a, b) -> a + b));



        // Mutable Reduction
        //StringBuilder erg = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        //TreeSet<String> erg = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        //ArrayList<String> erg = str.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        //List<String> erg = str.collect(Collectors.toList());
        //Set<String> erg = str.collect(Collectors.toSet());
        // Collection<String> erg = str.collect(Collectors.toCollection(HashSet::new));

        // String erg = str.collect(Collectors.joining());
        // String erg = str.collect(Collectors.joining("-"));
        // String erg = str.collect(Collectors.joining("-", "#", "#"));


        //        Map
        //          1 List h, a, l, l, o
        //          2 List !!

        //Map<Integer, List<String>> erg = str.collect(Collectors.groupingBy(String::length));

        Map<Boolean, List<String>> erg = str.collect(Collectors.partitioningBy(s -> s.length() == 1));
        System.out.println(erg.get(true));


    }

}

