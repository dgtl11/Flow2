// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.3 - Generic Methods
 *
 *  Listing: - 2.2.08 - Methods.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


public class Methods{

    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }

    public static <T> void sink(T t) { }
    public static <T> T identity(T t) { return t; }
    // public static T noGood(T t) { return t; } // DOES NOT COMPILE

    // Real World Scenario
    /*
    Box.<String>ship("package");
    Box.<String[]>ship(args);
    */
}

