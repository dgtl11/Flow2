// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.11 - AssertionTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.assertions;



public class AssertionTester {

    int i = 10;

    public static void main(String[] args) {

        AssertionTester at = new AssertionTester();
        at.i = 12;
        at.machWas(5);

    }

    public void machWas (int i) {
        // assert  == 10;
        /*
        i += 1;
        System.out.println(i );
        try {
            assert i == 11 : "Der Wert von i passt nicht";
        } catch (AssertionError e) {
            e.printStackTrace();
        }
        */
        assert pow(i, 2) == i * i: "Der Wert von i passt nicht";

    }

    public int pow(int i, int p) {
        return (int) Math.pow(i, p);
    }
}

