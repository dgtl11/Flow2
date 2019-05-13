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


import java.util.concurrent.atomic.AtomicInteger;

public class Th2 {
    private static class CStore implements Runnable {
        int x;
        private AtomicInteger cps = new AtomicInteger(0);

        public void run() {

            while(x<2) {
                x = cps.getAndIncrement();

                try {
                    // Thread.sleep(500);

                } catch (Exception e) {
                    System.out.print(e);
                }
                System.out.print(x);
            }
        }
    }

    public static void main(String[] args) {
        CStore cs = new CStore();

        Thread th1 = new Thread(cs);
        Thread th2 = new Thread(cs);
        Thread th3 = new Thread(cs);
        th1.start();
        th2.start();
        th3.start();

    }
}

