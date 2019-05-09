// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.25 - ThreadTest2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

public class ThreadTest2 {

    public static void main(String[] args) {
        
        Thread t = new MyThread();
        // t.run();        // wird von JVM aufgerufen
        t.start();      // starten seperaten Thread

        Thread t2 = new Thread () {
            @Override
            public void run() {
                System.out.println(getName() + ": Hi ");
            }
        };

        t2.start();


        Runnable aufgabe = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": Hi vom Runnable");
            }
        };

        Thread t3 = new Thread(aufgabe);
        t3.start();

        Runnable aufgabe2 = () -> System.out.println(Thread.currentThread().getName() + ": Hi von Lambda");
        Thread t4 = new Thread(aufgabe2);
        t4.start();

        t4 = new Thread(aufgabe2);
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();


        System.out.println(Thread.currentThread().getName() + " Ende");
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + ": Maoi Moin ");
    }
}