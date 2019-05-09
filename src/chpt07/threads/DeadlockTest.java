// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.32 - DeadlockTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

public class DeadlockTest {

    static Object o1 = new Object();
    static int[] o2  = new int[10];

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
           while(true) {

               synchronized (o1) {
                   synchronized (o2) {
                       System.out.println(o1 + " " + o2);
                   }
               }
           }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
                synchronized (o2) {
                    synchronized (o1) {
                        System.out.println(o2 + " " + o1);
                    }
                }
            }
        });

        t1.start();
        t2.start();

        findDeadlock();

        // System.out.println("Ende");

    }

    // deadlocktest
    static void findDeadlock() {
        ThreadMXBean tb = ManagementFactory.getThreadMXBean();
        long[] ids = tb.findMonitorDeadlockedThreads();
        if(ids != null) {
            for(long l : ids)
                System.out.println(l);

        }
    }

}

