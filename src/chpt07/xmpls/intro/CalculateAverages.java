// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.1 - Introducing Threads
 *
 *  Listing: - 07.1.03 - CalculateAverages.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.intro;

/*  // Basic Example

public class CalculateAverage implements Runnable {
    public void run() {
        // Define work here
    }
}

*/

public class CalculateAverages implements Runnable {
    private double[] scores;
    public CalculateAverages(double[] scores) {
        this.scores = scores;
    }
    public void run() {
        // Define work here that uses the scores object
    }
}