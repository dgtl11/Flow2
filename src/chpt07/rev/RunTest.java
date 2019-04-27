// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.10 - Review
 *
 *  Listing: - 07.10.02 - RunTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;

public class RunTest {
    static class Runner implements Runnable {
        public void run() {
            System.out.println("In Run");
        }
    }

    public static void main(String[] args) {
        Runner r = new Runner();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}