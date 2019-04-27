// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.2 - Creating Threads with ExecutorService
 *
 *  Listing: - 07.2.10 - AmbiguousLambdaSample.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.exeService;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class AmbiguousLambdaSample {
    public static void useCallable(Callable<Integer> expression) {}
    public static void useSupplier(Supplier<Integer> expression) {}
    public static void use(Supplier<Integer> expression) {}
    public static void use(Callable<Integer> expression) {}
    public static void main(String[] args) {
        useCallable(() -> {throw new IOException();});      // COMPILES
        // useSupplier(() -> {throw new IOException();});   // DOES NOT COMPILE
        // use(() -> {throw new IOException();});           // DOES NOT COMPILE

        // ambiguity can be resolved with an explicit cast.
        use((Callable<Integer>)() -> {throw new IOException("");}); // COMPILES
    }
}
