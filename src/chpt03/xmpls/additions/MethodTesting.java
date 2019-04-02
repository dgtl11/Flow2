// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.6 - Additions in Java 8
 *             2.6.2 - Removing Conditionally
 *             2.6.3 - Updating All Elements
 *             2.6.4 - looping through a Collection
 *
 *  Listing: - 2.6.34 - MethodTesting.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.additions;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodTesting {

    public static void main(String[] args) {

        // syntax removIf
        // boolean removeIf(Predicate<? super E> filter)
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);       // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list);       // [Magician]


        // void replaceAll(UnaryOperator<E> o)
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        list2.replaceAll(x -> x*2);
        System.out.println(list2);      // [2, 4, 6]

        // looping through a Collection
        List<String> cats = Arrays.asList("Annie", "Ripley");
        for(String cat: cats)
            System.out.println(cat);

        // We can do the same thing with lambdas in one line:
        cats.forEach(c -> System.out.println(c));

        // it is common to use a method
        // reference instead:
        cats.forEach(System.out::println);
    }
}

