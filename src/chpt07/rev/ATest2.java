// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Review Questions
 *
 *  Listing: - 07.12.50 - Th2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;


import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ATest2 {

    private AtomicInteger value = new AtomicInteger(10);



    public static void main(String[] args) {
        ATest2 at = new ATest2();
        // insert here

        // a
        // at.value = new Integer(15);
        // System.out.println(at.value.intValue());

        // b
        // at.value = 15;
        // System.out.println(at.value.intValue());

        // c
        // at.value = at.value.getAndAdd(5);
        //System.out.println(at.value.intValue());

        // d
        at.value.weakCompareAndSet(10,15);
        System.out.println(at.value.intValue());

        // e
        System.out.println(at.value.addAndGet(5));
    }
}

