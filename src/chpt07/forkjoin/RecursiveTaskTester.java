// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.60 - RecursiveTaskTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.forkjoin;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTester {
    public static void main(String[] args) throws InterruptedException {

        Instant start = Instant.now();

        // ForkJoinPool pool = new ForkJoinPool();
        // long wert = pool.invoke(new MyRecursiveTask(1_000_000));
        // System.out.println(wert);

        long sum = 0;
        for(int i = 0; i < 1_000_000; i++) {
            sum += Math.ceil(Math.random() * 100) + 1;
        }
        System.out.println(sum);

        Instant ende = Instant.now();
        System.out.println(Duration.between(start, ende));
    }
}

class MyRecursiveTask extends RecursiveTask<Long> {

    long count;

    public MyRecursiveTask(long count) {
        this.count = count;
    }

    @Override
    protected Long compute() {

        long sum = 0;

        if (count <= 1000) {
            // Aufgabe ist klein genug
            for(int i = 0; i < count; i++) {
                sum += Math.ceil(Math.random() * 100);
            }
        } else {
            // zu groß muss geteilt werden

            // List<MyRecursiveTask> tasks = new ArrayList<>();
            // Teilaufgaben erzeugen
            // tasks.add(new MyRecursiveTask(count / 2));
            // tasks.add(new MyRecursiveTask(count / 2));
            // tasks.add(new MyRecursiveTask());

            // Teilaufgaben synchron starten
            // for (MyRecursiveTask task : tasks) {
            //     task.fork();
            // }

            // Ergebnisse der Teilaufgaben einsammeln
            // for (MyRecursiveTask task : tasks) {
            //     sum += task.join();
            // }

            final MyRecursiveTask left = new MyRecursiveTask( count / 2);
            final MyRecursiveTask right = new MyRecursiveTask(count / 2);

            left.fork();
            sum += right.compute();
            sum += left.join();

        }
        return sum;
    }
}

