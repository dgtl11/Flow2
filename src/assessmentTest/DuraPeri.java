// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.16 - DuraPeri.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.time.*;


public class DuraPeri {
    public static void main(String[] args) {
        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();
        boolean b1 = d == p;
        boolean b2 = d.equals(p);
        System.out.println(b1 + " " + b2);
    }
}