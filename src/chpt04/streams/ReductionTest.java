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

import java.util.TreeSet;
import java.util.stream.Stream;

public class ReductionTest {
    
    public static void main(String[] args) {
        
        Stream<String> str = Stream.of("H","a","l","l","o");
        // System.out.println(str.reduce("", (a, b) -> a + b));

        // StringBuilder erg = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        // StringBuilder sb = new StringBuilder();
        // sb.append()

        TreeSet<String> erg = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        System.out.println(erg);
    }
}
