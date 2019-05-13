// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Whizlabs Test Questions
 *
 *  Listing: - 07.12.53 - ETest3.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ETest3 {

    static class Task1 implements Runnable {
        public void run(){
            System.out.println("Task1");
        }
    }
    static class Task2 implements Runnable {
        public void run() {
            System.out.println("Task2");
            try {
                Thread.sleep(4500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        Future f1 = pool.submit(new Task1());
        Future f2 = pool.submit(new Task2());

        pool.awaitTermination(4, TimeUnit.SECONDS);

        pool.shutdownNow();
    }
}

