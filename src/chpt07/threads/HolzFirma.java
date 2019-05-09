// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.8.34 - HolzFirma.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

class Holz {

}

class Lager {

    private final List<Holz> gelagertesHolz = new ArrayList<>(20);

    synchronized void einlagern(Holz holz) {
        System.out.println(Thread.currentThread().getName() + " will Holz einlagern ");
        while(gelagertesHolz.size() == 20) {
            try {
                System.out.println(Thread.currentThread().getName() + " wartet");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }
        gelagertesHolz.add(holz);
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " hat Holz eingelagert");
        System.out.println("Neuer Lgerbestand: " + gelagertesHolz.size());
    }

    synchronized Holz abholen() {
        System.out.println(Thread.currentThread().getName() + " will Holz abholen ");
        while(gelagertesHolz.size() == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " wartet");
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }
        Holz holz = gelagertesHolz.remove(gelagertesHolz.size() -1);
        System.out.println(Thread.currentThread().getName() + " hat Holz abgeholt");
        System.out.println("Neuer Lgerbestand: " + gelagertesHolz.size());
        this.notifyAll();
        return holz;
    }

}

class Holzfealler implements Runnable {

    private final Lager lager;

    public Holzfealler(Lager lager) {
        this.lager = lager;
    }

    @Override
    public void run() {
        while(true) {
            lager.einlagern(new Holz());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }
    }
}

class Handler implements Runnable {
    private final Lager lager;

    public Handler(Lager lager) {
        this.lager = lager;
    }

    @Override
    public void run() {
        while(true) {
            lager.abholen();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                // e.printStackTrace();
            }
        }
    }
}

public class HolzFirma {

    public static void main(String[] args) {

        Lager lager = new Lager();

        Thread t1 = new Thread(new Holzfealler(lager), "Peter");
        Thread t2 = new Thread(new Holzfealler(lager), "Bruce");
        Thread t3 = new Thread(new Holzfealler(lager), "Clark");

        Thread t4 = new Thread(new Handler(lager), "Tony");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}



