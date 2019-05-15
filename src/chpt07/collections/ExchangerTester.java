// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.5 - Working with Parallel Streams
 *
 *  Listing: - 07.5.64 - ExchangerTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.collections;

import java.util.concurrent.Exchanger;

public class ExchangerTester {

    public static void main(String[] args) {

        Exchanger treffpunkt = new Exchanger();

        new Thread(new Dealer(treffpunkt)).start();
        new Thread(new Customer(treffpunkt)).start();

    }
}

class Dealer implements Runnable {

    private Exchanger treffpunkt;
    private Stuff stuff;

    public Dealer(Exchanger treffpunkt) {
        this.treffpunkt = treffpunkt;
        this.stuff = new Stuff("Geklautes Fahrrad");
    }

    @Override
    public void run() {
        System.out.println("Dealer: Start ");

        try {
            System.out.println("Schaut sich erstmal die Gegend an .. ");
            Thread.sleep(1000);
            stuff = (Stuff) treffpunkt.exchange(stuff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Dealer: " + stuff.getName());
    }
}

class Customer implements Runnable {

    private Exchanger treffpunkt;
    private Stuff stuff;

    public Customer(Exchanger treffpunkt) {
        this.treffpunkt = treffpunkt;
        this.stuff = new Stuff("GoldPieces / ganz viel Geld ");
    }

    @Override
    public void run() {
        System.out.println("Customer: Start ");

        try {
            stuff = (Stuff) treffpunkt.exchange(stuff);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Customer: " + stuff.getName());
    }
}

class Stuff {
    private String name;

    public Stuff (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}