// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.3 - Synchronizing Data Access
 *
 *  Listing: - 07.3.14 - SheepManager.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.synchronizing;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {

    private int sheepCount = 0;
    private void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for(int i=0; i<10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }

}
