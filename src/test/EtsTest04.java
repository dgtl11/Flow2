// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test 04
 *
 *  Listing: - 11.0.04 - EtsTest04.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class EtsTest04 {
    public static void main(String[] args) {

        Duration d = Duration.ofDays(1);
        System.out.println(d);
        System.out.println();

        d = Duration.ofMinutes(0);
        System.out.println(d);
        System.out.println();

        Period p = Period.ofMonths(0);
        System.out.println(p);
        System.out.println();

        Duration du = Duration.ofMillis(1100);
        System.out.println(du);
        System.out.println();

        du = Duration.ofSeconds(61);
        System.out.println(du);
        System.out.println();

        Duration due = Duration.of(1, ChronoUnit.HALF_DAYS);
        due = due.plus(60,ChronoUnit.MINUTES);
        System.out.println(due);
        System.out.println(due.minus(due));

    }
}