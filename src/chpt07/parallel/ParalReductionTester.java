// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.61 - ParalStreamTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.parallel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


public class ParalReductionTester {

    public static void main(String[] args) {

        // a + b + c  =  (a + b) + c  =  a + (b + c)

        System.out.println("~~~~~~~~~~~~ reduce() ~~~~~~~~~~~~~~");

        String str =
        Arrays.asList("Peter", "Clark", "Bruce", "Dani")
                .parallelStream()
                // .reduce("", (a,b)-> a+ ", " + b, (a,b)-> a+ ", " + b);
                .reduce(" ", String::concat, String::concat);

        System.out.println(str);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        int ints =
                Arrays.asList(1,2,3,4,5)
                        .stream()
                        .reduce(0, (a,b)-> a + b, (a,b)-> a + b);

        System.out.println(str);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        int intspara =
                Arrays.asList(1,2,3,4,5)
                        .parallelStream()
                        .reduce(0, (a,b)-> a + b, (a,b)-> a + b);

        System.out.println(str);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        int intsmulti =
                Arrays.asList(1,2,3,4,5)
                        .parallelStream()
                        .reduce(0, (a,b)-> a * b, (a,b)-> a * b);

        System.out.println(str);

        System.out.println("~~~~~~~~~~~~~~~ collect() ~~~~~~~~~~~~");

        // a + b + c  =  (a + b) + c  =  a + (b + c)

        TreeSet<String> set =
        Arrays.asList("Peter", "Clark", "Bruce", "Dani")
                .parallelStream()
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

        System.out.println(set);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        ArrayList<String> list =
        Arrays.asList("Peter", "Clark", "Bruce", "Dani")
                .parallelStream()
                // .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(list);

    }
}
