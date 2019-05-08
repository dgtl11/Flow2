// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - WhizLabs Foundation Test
 *
 *  Listing: - 11.0.01 - TestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.util.Arrays;

enum Test {
    NIX, NUR, GRR, ARG;
}

public class TestClass {
    public static void main(String[] args) {

        Test[] werte = {Test.GRR, Test.NIX, Test.NUR, Test.ARG};
        Arrays.sort(werte);

        for (Test t : werte) {
            System.out.println(t);
        }
    }
}