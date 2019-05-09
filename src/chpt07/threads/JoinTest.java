// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.29 - JoinTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable aufgabe = () -> {
            String name = Thread.currentThread().getName();

            for(int i = 0; i< 100; i++) {

                System.out.println(name + ": hi ... " + i);
            }
        };

        Thread t1 = new Thread(aufgabe);
        t1.start();

        Thread t2 = new Thread(aufgabe);
        t2.start();

        t1.join(1000);      // main wartet auf Ende von t1
        System.out.println("Ende");

        // wird erst gestarted wenn t1 beendet ist
        Thread t3 = new Thread(aufgabe);
        t3.start();

    }
}

