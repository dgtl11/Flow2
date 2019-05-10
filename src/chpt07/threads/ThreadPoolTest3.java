// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.44 - ExecutorServiceTest2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadPoolTest3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Bar scumbar = new Bar();

        scumbar.bestellen(new Bestellung("Pepsi"));
        scumbar.bestellen(new Bestellung("Light"));
        scumbar.bestellen(new Bestellung("7up"));
        scumbar.bestellen(new Bestellung("Water"));
        scumbar.bestellen(new Bestellung("Mirinda"));

        scumbar.wirklichSchließen();

    }
}

class Bar {

    int cores = Runtime.getRuntime().availableProcessors();
    long memory = Runtime.getRuntime().totalMemory();

    private ExecutorService service = Executors.newFixedThreadPool(cores);       // fitting for cores
    // private ExecutorService service = Executors.newFixedThreadPool(5);       // 5 fixed Threads
    // private ExecutorService service = Executors.newCachedThreadPool();      // flexibler

    public void bestellen(Bestellung bestellung) {
        service.submit(bestellung);         // run oder callable
    }

    public void schließen() {
        service.shutdown();
    }

    public void wirklichSchließen() {
        service.shutdown();

        try {
            if(!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
                if(!service.awaitTermination(30, TimeUnit.SECONDS)) {
                    System.out.println("Kritischer Fehler beim Beenden von laufenden Threads");

                }
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

class Bestellung implements Callable<Void> {        // Wrapper für nichts

    String name;

    public Bestellung(String name) {
        this.name = name;
    }

    @Override
    public Void call() throws Exception {
        System.out.println(name);
        return null;
    }
}