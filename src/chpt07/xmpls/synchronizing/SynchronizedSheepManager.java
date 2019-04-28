// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.3 - Synchronizing Data Access
 *
 *  Listing: - 07.3.16 - SynchronizedSheepManager.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.synchronizing;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedSheepManager {

    // they are all running random

    private int sheepCount = 0;
    // private void incrementAndReport() {
    //    System.out.print((++sheepCount)+" ");
    // }


    // but at least count right
    // private AtomicInteger sheepCount = new AtomicInteger(0);
    // private void incrementAndReport() {
    //    System.out.print(sheepCount.incrementAndGet()+" ");
    // }

/*
    private void incrementAndReport() {
        synchronized(this) {
            System.out.print((++sheepCount)+" ");
        }
    }
*/
    // would also work
/*    private final Object lock = new Object();
    private void incrementAndReport() {
        synchronized(lock) {
            System.out.print((++sheepCount)+" ");
        }
    }
*/
    // synchronized method equivalent to synchronised(this):
    private synchronized void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }


    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SynchronizedSheepManager manager = new SynchronizedSheepManager();
            for(int i=0; i<10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }

    // static synchronized equivalents
/*    public static void printDaysWork() {
        synchronized(SynchronizedSheepManager.class) {
            System.out.print("Finished work");
        }
    }
*/
    public static synchronized void printDaysWork() {
        System.out.print("Finished work");
    }

}
