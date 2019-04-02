// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.6 - Additions in Java 8
 *             2.6.1 - Using Method References
 *
 *  Listing: - 2.6.33 - DuckHelperTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.additions;


import chpt03.xmpls.compare.Duck2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DuckHelperTester {

    public static void main(String[] args) {

        // Using lambdas
        Comparator<Duck2> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);

        Comparator<Duck2> byWeight2 = DuckHelper::compareByWeight;


        // static method:
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);


        // instance method on a specifi c instance:
        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);


        // without knowing the instance in advance:
        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();


        // Finally, we have a constructor reference:
        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();

    }
}

