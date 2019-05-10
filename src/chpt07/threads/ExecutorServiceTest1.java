// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.44 - ExecutorServiceTest1.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ExecutorServiceTest1 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(() -> {
            for(int i =0; i < 50; i++) {
                System.out.println("Moin");
            }
        });

        service.execute(() -> {
            for(int i = 0; i < 50; i++) {
                System.out.println("Hi");
            }
        });


        Future f = service.submit(() -> {
            for(int i = 0; i < 50; i++) {
                System.out.println("Tach auch .. ");
            }
        });

        Future f2 = service.submit(() -> {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 50; i++) {
                sb.append(i);
            }
            return sb.toString();
        });

        try {
            System.out.println(f.get());
            System.out.println(f2.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }

        service.shutdown();
    }
}

