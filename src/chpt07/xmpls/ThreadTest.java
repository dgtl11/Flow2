// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.0 -
 *
 *  Listing: - 07.0.01 - ThreadTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls;

public class ThreadTest {
    public static void main(String[] args) {

        System.out.println("Moin");

        Thread t1 = new Thread(()-> {
            try {
                Thread.sleep(2000);
                System.out.println("...");

            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();

        System.out.println("bis später... ");

    }
}