// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.12 - Review WhizLabs Thread Test
 *
 *  Listing: - 07.12.40 - RunTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.rev;

public class WhizLabsTest {

    public static void main(String[] args) {



    }
}

class MyOtherThread extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait(5009);
            } catch (InterruptedException e) {

            }
        }
    }
}