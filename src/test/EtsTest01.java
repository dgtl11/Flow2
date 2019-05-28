// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test 01
 *
 *  Listing: - 11.0.10 - EtsTest01.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class EtsTest01 {
    public static void main(String[] args) {

        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b) -> a>b?a:b));   // 1
        // = 9
        System.out.println(ls.stream().max(Integer::max).get());                        // 2
        // = 3
        System.out.println(ls.stream().max(Integer::compareTo).get());                  // 3
        // = 9
        System.out.println(ls.stream().max((a, b) -> a>b?a:b));                         // 4
        // = Optional[9]

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Deque<Integer> d = new ArrayDeque<>();
        d.push(1);
        d.offerLast(2);
        d.push(3);
        d.peekFirst();
        d.removeLast();
        d.pop();
        System.out.println(d);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

//        Duration d = Duration.ofDays(1);
//        System.out.println(d);
//        System.out.println();
//
//        d = Duration.ofMinutes(0);
//        System.out.println(d);
//        System.out.println();
//
//        Period p = Period.ofMonths(0);
//        System.out.println(p);
//        System.out.println();
//
//        Duration du = Duration.ofMillis(1100);
//        System.out.println(du);
//        System.out.println();
//
//        du = Duration.ofSeconds(61);
//        System.out.println(du);
//        System.out.println();
//
//        Duration due = Duration.of(1, ChronoUnit.HALF_DAYS);
//        due = due.plus(60,ChronoUnit.MINUTES);
//        System.out.println(due);
//        System.out.println(due.minus(due));

    }
}