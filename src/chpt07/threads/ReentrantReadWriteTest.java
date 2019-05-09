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

    }

    String get (int index) {

        try {
            readLock.lock();
            return liste.get(index);
        } finally {
            readLock.unlock();
        }
    }

    void add(String wert) {

        try {
            writeLock.lock();
            liste.add(wert);
        } finally {
            writeLock.unlock();
        }
    }

}



