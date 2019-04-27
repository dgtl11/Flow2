// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.1 - Introducing Threads
 *
 *  Listing: - 07.1.04 - PrintData.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.intro;

public class PrintData implements Runnable {
    public void run() {
        for(int i=0; i<3; i++)
            System.out.println("Printing record: "+i);
    }
    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}

/*
public class ReadInventoryThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }
    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }
}
*/
