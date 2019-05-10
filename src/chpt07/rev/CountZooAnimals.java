// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Review Questions
 *
 *  Listing: - 07.12.43 - CountZooAnimals.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CountZooAnimals {
    public static Integer performCount(int exhibitNumber) {
        // IMPLEMENTATION OMITTED
        return 1;
    }
    public static void printResults(Future<?> f) {
        try {
            System.out.println(f.get()); // o1
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        final List<Future<?>> results = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> results.add(
                        service.submit(() -> performCount(i)))); // o2
        results.stream().forEach(f -> printResults(f));
        service.shutdown();
    }
}

