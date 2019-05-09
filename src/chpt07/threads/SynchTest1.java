// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.30 - SynchTest1.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


public class SynchTest1 {

    public static void main(String[] args) {

        // jedes sein eigenes this
        // Object o1 = SynchTest1.class;
        // Object o2 = SynchTest1.class;

        Runnable aufgabe = () -> {
            // machWasStatic();
            // new SynchTest1().machWas();
            machWasBlock();
        };

        Thread t1 = new Thread(aufgabe);
        Thread t2 = new Thread(aufgabe);
        Thread t3 = new Thread(aufgabe);
        Thread t4 = new Thread(aufgabe);
        Thread t5 = new Thread(aufgabe);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    // this
    public synchronized void machWas() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": Moin");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name + ": Bis dann... ");
    }

    // class
    public static synchronized void machWasStatic() {

        String name = Thread.currentThread().getName();
        System.out.println(name + ": Moin");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name + ": Bis dann... ");

    }

    // block
    public static void machWasBlock() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " bin drin!");

        synchronized (SynchTest1.class) {
            System.out.println(name + ": Moin");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(name + ": Bis dann... ");
        }

    }
}

