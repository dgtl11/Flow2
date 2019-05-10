// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.36 - ReentrantReadWriteTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StateTest {

    public static void main(String[] args) throws InterruptedException {

        String lock = "Ich bin ein Lock ";

        Thread t1 = new Thread(() -> {

            Thread ike = Thread.currentThread();

            while (true) {
                if(ike.isInterrupted()) {
                    break;
                }
                // RUNNABLE : lauffähig
                synchronized (lock) {
                    System.out.println(ike.getState());
                    try {
                        lock.wait();        // löst interruped aus
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage()); // null
                    }

                }

            }
        });

        // NEW : erzeugt aber nicht gestartet
        System.out.println(t1.getState());

        t1.start();
        t1.sleep(50);

        // Waiting
        System.out.println(t1.getState());

        synchronized (lock) {
            lock.notify();
            // BLOCKED
            System.out.println(t1.getState());
        }

        t1.interrupt();
        t1.join();

        // TERMINATED : run-Methode ist abgearbeitet
        System.out.println(t1.getState());
    }
}



