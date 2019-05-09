// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.27 - RaceConditionsTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import chpt07.xmpls.ThreadTest;

public class RaceConditionsTest {

    public static void main(String[] args) {

        Runnable aufgabe = new Runnable() {

            int count = 0;

            private void up() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }

            private void down() {
                count--;
            }

            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                up();
                System.out.println(name + " " + count);
                down();
                System.out.println(name + " " + count);

            }
        };

        Thread t1 = new Thread(aufgabe);
        Thread t2 = new Thread(aufgabe);
        Thread t3 = new Thread(aufgabe);
        Thread t4 = new Thread(aufgabe);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

