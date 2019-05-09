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
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteTest {

    private final List<String> liste = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {

        ReentrantReadWriteTest test = new ReentrantReadWriteTest();

        Thread t1 = new Thread( () -> {
           test.add("Moin");
        });

        Thread t2 = new Thread( () -> {
            test.add("Hi");
        });

        Thread t3 = new Thread( () -> {
            System.out.println(test.get(test.liste.size() -1));
        });

        Thread t4 = new Thread( () -> {
            System.out.println(test.get(test.liste.size() -1));
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    String get (int index) {
        try {
            readLock.lock();
            System.out.println("Lesen: ");
            return liste.get(index);
        }
        finally {
            readLock.unlock();
        }
    }

    void add(String wert) {
        try {
            writeLock.lock();
            System.out.println("Schreiben: ");

            liste.add(wert);
        }
        finally {
            writeLock.unlock();
        }
    }
}



