// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.13 - NewMethodTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NewMethodTest {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,5,7,8,9,15,22));

        ints.removeIf(i -> i > 10);
        System.out.println(ints);

        ints.replaceAll((i) -> {
            if(i == 1 ||i == 5){
                return 0;
            }
            return i;
        });

        System.out.println(ints);

        // int iExt =

        ints.forEach((i) -> System.out.println(i + "..."));

        // Maps
        Map<String, String> map = new HashMap<>();
        map.put("Spiderman", "Peter Parker");
        map.put("Super Man", "Clark Kent");
        map.put("Iron Man", "Tony Stark");
        map.put("Batman", "Bruce Wayne");

        // nicht wenn Batman schon da ist
        System.out.println(map.putIfAbsent("Batman", "Pawel Batmanski"));

        System.out.println(map);

        BiFunction<String, String, String> bif1 = (val1, val2) -> {
            System.out.println(val1);
            System.out.println(val2);
            // return val1 + " aka " + val2;
            return null;
        };

        // merge
        map.merge("Batman", "Pawel Batmanski", bif1);
        System.out.println(map);

        BiFunction<String, String, String> bif2 = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
            // return s1 + "_" + s2;
            return null;
        };

    //    System.out.println(map.computeIfPresent("Batman", bif2 ));
    //    System.out.println(map);

        System.out.println("--------------------------------------");

        Function<String, String> f1 = (i) -> {
            System.out.println(i);
            return i + "...";
        };

        System.out.println(map.computeIfAbsent("Hulk", f1));
        System.out.println(map);




    }
}

