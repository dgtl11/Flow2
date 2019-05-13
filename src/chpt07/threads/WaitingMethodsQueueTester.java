// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.58 - WaitingMethodsQueueTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class WaitingMethodsQueueTester {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> q = new ArrayBlockingQueue<>(1);
        q.offer("Peter");
        // q.put("Bruce");
        q.offer("clark" , 2, TimeUnit.SECONDS);
        System.out.println();
        System.out.println(q.poll(2,TimeUnit.SECONDS));
        System.out.println("Ende");
    }
}

