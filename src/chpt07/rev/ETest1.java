// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Whizlabs Test Questions
 *
 *  Listing: - 07.12.51 - ETest1.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ETest1 {

    static class Task1 implements Callable<Integer> {
        public Integer call(){
            return 1;
        }
    }
    static class Task2 implements Callable<Integer>{
        public Integer call(){
            return 2;
        }
    }
    static class Task3 implements Callable<Double>{
        public Double call(){
            return 3.0;
        }
    }
    public static void main(String[] args) throws Exception {
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> cal = new ArrayList<Callable<Integer>>();

        cal.add(new Task2());
        cal.add(new Task1());

        List<Future<Integer>> futures = pool.invokeAll(cal);

        for(Future<Integer> future:futures){
            System.out.println("Task" + future.get());
        }
        pool.shutdownNow();
    }
}

