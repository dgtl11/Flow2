// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.14 - ExceptionXmpls.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls;


public class ExceptionXmpls {

    public static void main(String[] args) {

        // ArrayStoreEx
        // kann ich mit primitiven nicht erzeugen
        int[] ints = new int[10];
        // ints[0] = 100L;
        // compilerError

        // so geht es
        Number[] nums = new Byte[10];      // can be NegativeArraySizeEx
        nums[0] = 1L;
        // classCast Ex für Arrays
    }

}


