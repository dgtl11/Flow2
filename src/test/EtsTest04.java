// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test 04
 *
 *  Listing: - 11.0.04 - EtsTest04.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.time.Duration;
import java.time.Period;
import java.util.Arrays;

public class EtsTest04 {
    public static void main(String[] args) {

        Thread[] t = new Thread[5];

        Duration d = Duration.ofDays(1);
        System.out.println(d);
        d = Duration.ofMinutes(0);
        System.out.println(d);
        Period p = Period.ofMonths(0);
        System.out.println(p);

        System.out.println();

        Duration du = Duration.ofMillis(1100);
        System.out.println(du);
        du = Duration.ofSeconds(61);
        System.out.println(du);

    }
}