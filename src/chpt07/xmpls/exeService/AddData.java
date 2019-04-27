// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.2 - Creating Threads with ExecutorService
 *
 *  Listing: - 07.2.11 - AddData.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.exeService;

import java.util.concurrent.*;

public class AddData {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30+11);
            System.out.println(result.get());
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
