// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.59 - ForkJoinTester1.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.forkjoin;


import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTester1 {
    public static void main(String[] args) throws InterruptedException {

        // List<Integer> rand = Collections.synchronizedList(new ArrayList<>());
        Integer[] rand = new Integer[20_000_000];

        ForkJoinPool pool = new ForkJoinPool();
        // System.out.println(pool.getParallelism());

        Instant start = Instant.now();

        // RandomGeneratorAction action = new RandomGeneratorAction(rand, 20_000);
        // pool.invoke(action);

        // or

        Random gen = new Random();
        for(int i = 0; i< 20_000; i++) {
            // rand.add(gen.nextInt(100));
            rand[i] = gen.nextInt(100);
        }

        // System.out.println(rand.size());
        System.out.println(rand.length);

        Instant ende = Instant.now();
        System.out.println(Duration.between(start, ende).get(ChronoUnit.NANOS)); //

        // rand.forEach(System.out::println);
        for(int i : rand) {
            System.out.println(i);
        }
    }
}

class RandomGeneratorAction extends RecursiveAction {

    // List<Integer> rand;
    Integer[] rand;

    // int num;
    int start;
    int ende;

    // public RandomGeneratorAction(List<Integer> rand, int num) {
    //    this.rand = rand;
    //    this.num = num;
    // }

    public RandomGeneratorAction(Integer[] rand, int start, int ende) {
        this.rand = rand;
        this.start = start;
        this.ende = ende;
    }

    // @Override
    // protected void compute() {
    //    if(num <= 100) {
    //        // erledigen
    //        Random gen = new Random(100);
    //        for(int i = 0; i< num ; i++) {
    //            rand.add(gen.nextInt(100));
    //        }
    //    }
    //    else {
    //        // teilen
    //        invokeAll(new RandomGeneratorAction(rand, num / 2), new RandomGeneratorAction(rand, num /2));
    //    }
    // }

    @Override
    protected void compute() {
        if(ende - start <= 1000) {
            // erledigen
            Random gen = new Random(100);
            for(int i = start; i< ende ; i++) {
                // rand.add(gen.nextInt(100));
                rand[i] = gen.nextInt(100);
            }
        }
        else {
            // teilen
            int range = start + ((ende - start) / 2 );
            // invokeAll(new RandomGeneratorAction(rand, num / 2), new RandomGeneratorAction(rand, num /2));
            invokeAll(new RandomGeneratorAction(rand,start, range), new RandomGeneratorAction(rand, range, ende));

        }
    }
}