// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.1 - Introducing Threads
 *
 *  Listing: - 07.1.07 - CheckResults.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.intro;

/*
public class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) {
        new Thread(() -> {
            for(int i=0; i<500; i++) CheckResults.counter++;
        }).start();
        while(CheckResults.counter<100) {
            System.out.println("Not reached yet");
        }
        System.out.println("Reached!");
    }
}
*/

// How many times will the while() loop in this code execute and output Not reached
// yet ? The answer is, we don’t know!


// improve this result by using the Thread.sleep()

public class CheckResults {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 500; i++) CheckResults.counter++;
        }).start();
        while (CheckResults.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }
        System.out.println("Reached!");
    }
}