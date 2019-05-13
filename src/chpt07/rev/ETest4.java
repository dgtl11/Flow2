// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Whizlabs Test Questions
 *
 *  Listing: - 07.12.54 - ETest4.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ETest4 {

    static class Task1 implements Runnable {
        public void run(){
            System.out.println("Task1");
        }
    }

    static class Task2 implements Runnable {
        public void run() {

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.println("Task2");
        }
    }

    public static void main(String[] args) throws Exception {
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        Future f1 = pool.submit(new Task1());
        Future f2 = pool.submit(new Task2());

        pool.awaitTermination(3, TimeUnit.SECONDS);

        pool.shutdownNow();
    }
}

