// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.31 - DeamonTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


public class DeamonTester {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
           while(true) {
               System.out.println("Moin");
           }
        });

        t1.setDaemon(true);
        t1.start();

        Thread.sleep(2000);
        System.out.println("Ende");

    }
}

