// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.28 - InterruptTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable aufgabe = () -> {
            while(true) {
    //            if(Thread.currentThread().isInterrupted())
    //                  break;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    // e.printStackTrace();
                    break;
                }

                System.out.println("hi ... ");
            }
        };

        Thread t1 = new Thread(aufgabe);

        t1.start();

        Thread.sleep(2000);
        t1.interrupt();     // setzt nur das flag

        System.out.println("Ende");

    }
}

