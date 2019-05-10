// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.47 - ErinnerungTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.concurrent.*;

public class ErinnerungTest {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public void setzeErinnerung(Erinnerung erinnerung) {
        service.scheduleAtFixedRate(erinnerung, 0,500_000_000, TimeUnit.MICROSECONDS);
    }

    public static void main(String[] args)  {
        ErinnerungTest test = new ErinnerungTest();
        test.setzeErinnerung(new Erinnerung("Hamster Gassi führen / In's Rad lassen "));
        
    }
}

class Erinnerung implements Runnable {

    private String nachricht;

    public Erinnerung(String nachricht) {
        this.nachricht = nachricht;
    }

    @Override
    public void run() {
        System.out.println(nachricht);
    }
}
