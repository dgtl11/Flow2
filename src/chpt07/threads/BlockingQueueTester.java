// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.56 - BlockingQueueTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTester {
    public static void main(String[] args) {

        BlockingQueue<Anfrage> q = new ArrayBlockingQueue<>(5);

        Client c = new Client(q);
        Server s = new Server(q);

        new Thread(c).start();
        new Thread(s).start();

    }
}

class Anfrage {

}

class Client implements Runnable {
    private BlockingQueue<Anfrage> q;

    public Client(BlockingQueue<Anfrage> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            Anfrage a = null;
            while(true) {
                a = new Anfrage();
                q.put(a);
                System.out.println("Anfrage hinzugefügt");
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Server implements Runnable {
    private BlockingQueue<Anfrage> q;

    public Server(BlockingQueue<Anfrage> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            Anfrage a = null;
            while(true) {
                System.out.println("Verarbeitet: " + q.take());
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}