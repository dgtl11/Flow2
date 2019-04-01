// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.10 - AssertDemo.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;


public class AssertDemo {

    public static void main(String [] args) {
        Integer x = 10;
        x++;
        assert x == null && x >= 0;
        System.out.println(x);
    }
}