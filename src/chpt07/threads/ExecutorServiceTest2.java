// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.44 - ExecutorServiceTest2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceTest2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Set<Callable<Integer>> aufgaben = new HashSet<>();
        // Aufgaben in Set
        aufgaben.add(() -> {
            int sum = 0;
            for(int i = 0; i < 100; i++){
                sum += i;
            }
            return sum;
        });

        aufgaben.add(() -> {
            int sum = 0;
            for(int i = 100; i < 0; i--){
                sum += i;
            }
            return sum;
        });

        aufgaben.add(() -> {
            int sum = 0;
            for(int i = 100; i < 200; i++){
                sum += i;
            }
            return sum;
        });

        /*
        List<Future<Integer>> ergs = service.invokeAll(aufgaben);
        for(Future<Integer> f : ergs )
        System.out.println(f.get());
        */

        Integer erg = service.invokeAny(aufgaben);
        System.out.println(erg);


        service.shutdown();
    }
}

