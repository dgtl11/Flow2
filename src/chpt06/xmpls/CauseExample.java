// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.13 - CauseExample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls;


public class CauseExample {

    public static void main(String[] args) {
        try {
            machWas(10);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public static void machWas(int x) throws Exception {
        try {
            int z = x / 0;
        } catch (ArithmeticException e) {
            Exception newE = new Exception();
            newE.initCause(e);

            throw(newE);
        }

    }


}


