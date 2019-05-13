// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.57 - DelayQueueTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.util.concurrent.*;

public class DelayQueueTester {
    public static void main(String[] args) {

        BlockingQueue<WaitingElement> bq = new DelayQueue<>();

        try {
            bq.put(new WaitingElement(1000, "Peter"));
            bq.put(new WaitingElement(7000, "Clark"));
            bq.put(new WaitingElement(3000, "Bruce"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!bq.isEmpty()) {
            try {
                 System.out.println(bq.take().getName());
            } catch (InterruptedException e) {
                 e.printStackTrace();
            }
        }

    }
}

class WaitingElement implements Delayed {

    private long zeit;
    private final String name;

    public WaitingElement (long zeit, String name){
        this.zeit = zeit + System.currentTimeMillis();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long dif = zeit - System.currentTimeMillis();
        return dif;
    }

    @Override
    public int compareTo(Delayed o) {

        return (int) (o.getDelay(TimeUnit.MILLISECONDS) - zeit);

    }


}
