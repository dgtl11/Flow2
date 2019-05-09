// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.26 - ThreadTest3.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

public class ThreadTest3 {

    private int i = 10;

    public static void main(String[] args) {
        
        ThreadTest3 test = new ThreadTest3();

        Runnable aufgabe = () -> {
            while(test.i <= 10000) {
                System.out.println(Thread.currentThread().getName() + test.i++);
            }
        };

        Thread t1 = new Thread(aufgabe, "T1: ") ;
        Thread t2 = new Thread(aufgabe, "T2: " ) ;

        t1.start();
        t2.start();
    }
}

