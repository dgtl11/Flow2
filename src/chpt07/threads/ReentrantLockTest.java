// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.35 - ReentrantLockTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable aufgabe = () -> {
            String name = Thread.currentThread().getName();


            while (true) {
                if(lock.tryLock()) {
                    try {
                        System.out.println(name + ": Maion");
                        System.out.println(name + ": Bis dann .. ");
                    } finally {
                        lock.unlock();
                    }
                }

            }
        };

        Thread t1 = new Thread(aufgabe, "Peter");
        Thread t2 = new Thread(aufgabe, "Clark");

        t1.start();
        t2.start();

    }

}



