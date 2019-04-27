// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.2 - Creating Threads with ExecutorService
 *
 *  Listing: - 07.2.12 - WaitTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.exeService;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitTester {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            // Add tasks to the thread executor
            // ...
        } finally {
            if(service != null) service.shutdown();
        }
        if(service != null) {
            service.awaitTermination(1, TimeUnit.MINUTES);
                // Check whether all tasks are finished
            if(service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }
    }
}
