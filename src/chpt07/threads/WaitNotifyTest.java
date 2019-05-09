// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.33 - WaitNotifyTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class WaitNotifyTest {

    public static void main(String[] args) throws InterruptedException {

        Object raum = new Object();

        Dancer d1 = new Dancer(raum);
        Dancer d2 = new Dancer(raum);
        Dancer d3 = new Dancer(raum);
        Dancer d4 = new Dancer(raum);

        d1.start();
        d2.start();
        d3.start();
        d4.start();

        for(int i = 0; i < 5; i++) {
            Thread.sleep(5000);
            synchronized (raum) {
                raum.notify();      // nur einer
                raum.notifyAll();   // alle die warten
            }
        }

    }

}

class Dancer extends Thread {

    private final Object LOCK;

    Dancer(Object lock) {
        LOCK = lock;
    }
    public void run() {

        synchronized (LOCK) {

            try {
                System.out.println(getName() + ": Moin");
                LOCK.wait();
                System.out.println(getName() + ": Ende");

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}