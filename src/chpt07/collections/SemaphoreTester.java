// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.62 - SemaphoreTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.collections;

import java.util.concurrent.Semaphore;

public class SemaphoreTester {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2, true);
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();
        new Thread(new AndereAufgabe(sem)).start();

    }
}

class AndereAufgabe implements Runnable {

    private Semaphore sem;

    public AndereAufgabe (Semaphore sem) {
        this.sem = sem;
    }


    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + ": Start");

        try {
            sem.acquire();
            System.out.println(name + ": ticket gezogen");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + ": Ende");
            sem.release();
        }


    }

}