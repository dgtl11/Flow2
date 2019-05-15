// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.63 - CountDownLatchTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.collections;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchTester {

    static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) {

        System.out.println("Main: Start");

        new Thread().start();
        new Thread().start();
        new Thread().start();

        try {
            latch.await();
        } catch (InterruptedException e) {

        }
        System.out.println("Main: Ende");
    }
}

class Aufgabe implements Runnable {

    private CountDownLatch latch;

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + ": Start");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + ": Ende");

        latch.countDown();

    }
}