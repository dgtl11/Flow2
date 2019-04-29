// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.6 - Managing Concurrent Processes
 *
 *  Listing: - 07.6.23 - WeighAnimalTask.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.processes;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {

    private int start;
    private int end;
    private Double[] weights;
    public WeighAnimalTask(Double[] weights, int start, int end) {
        this.start = start;
        this.end = end;
        this.weights = weights;
    }
    protected Double compute() {
        if(end-start <= 3) {
            double sum = 0;
            for(int i=start; i<end; i++) {
                weights[i] = (double)new Random().nextInt(100);
                System.out.println("Animal Weighed: "+i);
                sum += weights[i];
            }
            return sum;
        } else {
            int middle = start+((end-start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
            otherTask.fork();
            return new WeighAnimalTask(weights,middle,end).compute() + otherTask.join();
        }
    }

    public static void main(String[] args) {
        // ForkJoinTask<Double> task = new WeighAnimalTask(weights,0,weights.length);
        // ForkJoinPool pool = new ForkJoinPool();
        // Double sum = pool.invoke(task);
        // System.out.println("Sum: "+sum);

        // RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
        // Double otherResult = otherTask.fork().join();
        // return new WeighAnimalTask(weights,middle,end).compute() + otherResult;

    }

}
