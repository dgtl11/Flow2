// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.65 - PhaserTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.collections;

import java.util.concurrent.Phaser;

public class PhaserTester {

    public static void main(String[] args) {

        Phaser phaser = new Phaser();

        new Thread(new NochEineAndereAufgabe(phaser, 500, true)).start();
        new Thread(new NochEineAndereAufgabe(phaser, 1000, true)).start();
        new Thread(new NochEineAndereAufgabe(phaser, 500, false)).start();
        new Thread(new NochEineAndereAufgabe(phaser, 2000, true)).start();
        // new Thread(new NochEineAndereAufgabe(phaser, 500)).start();

    }
}

class NochEineAndereAufgabe implements Runnable {

    private Phaser phaser;
    private long wartezeit;
    private boolean warten;

    public NochEineAndereAufgabe(Phaser phaser, long wartezeit, boolean warten) {
        this.phaser = phaser;
        this.wartezeit = wartezeit;
        this.warten = warten;
    }

    public NochEineAndereAufgabe (Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        if(warten)
            phaser.register();

        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + ": Start");
            Thread.sleep(2000);
            if(warten)
                phaser.arriveAndAwaitAdvance();
            // hier warten alle auf alle registrierten

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + ": Ende");

        }
    }
}