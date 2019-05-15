// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.15 - ExceptionTestTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.rev;

/*
class ExceptionTestTester {

    private void methodA(int i) {
        assert i >=0 : methodB();
        System.out.println(i);
    }

    private String methodB() {
        return "The value must not be negative";
    }

    public static void main(String[] args) {

        ExceptionTestTester test = new ExceptionTestTester();
        test.methodA(-10);


    }

}
*/

import java.time.Instant;

class AssertTest {

    /*  one Q
    public static void main(String[] args) {
        for(int i=0; i < 10; i++) {
            try {
                assert i%2==0 : i--;
                System.out.println("Even number : " + i );
            } catch (AssertionError ae) {
                System.out.println("Odd number : " + ++i);
            }
        }
    }*/


    // another Q
    /*
    static void testStrings() {
        try {
            String nulString = null;
            System.out.println(nulString.toString()+ " ");
        }
        finally {
            System.out.println("finally");
        }

    }

    public static void main(String[] args) {
        try { testStrings(); }
        catch (Exception e) {
            System.out.println("exception");
        }
    } */


    // yet another
    public static void main(String[] args) {
        boolean assertsEnabled = false;
        assert (assertsEnabled) : assertsEnabled = true;
        if(assertsEnabled) {
            System.out.println("asserting");
        }
    }
}

public class Ex6 {
    Integer I;

    public static void main(String[] args) {
        String s;

        try {
            s = new Ex6().I.toString();
        } finally {
            try {
                int i = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat");
            } finally {
                System.out.println("Fin2 ");
            }
            System.out.println("Fin1 ");
        }
    }
}
