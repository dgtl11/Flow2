// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.48 - CyclicBarrierTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrier b1 = new CyclicBarrier(2);
        CyclicBarrier b2 = new CyclicBarrier(2,()->{
            System.out.println("Durchbrochenes Target");
        });

        Ranger r1 = new Ranger("Max", new Point(10,5), new Point(7,-2) , b1, b2);
        Ranger r2 = new Ranger("Peter",new Point(7,8), new Point(3,-7) , b1, b2);

        r1.start();
        r2.start();

    }
}

class Ranger extends Thread {

    private Point pos = new Point(0,0);

    private Point target1;
    private Point target2;

    private CyclicBarrier barrier1;
    private CyclicBarrier barrier2;

    public Ranger(String name, Point target1, Point target2, CyclicBarrier barrier1, CyclicBarrier barrier2) {
        super(name);

        this.target1 = target1;
        this.target2 = target2;
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            while(!move(pos, target1)) {
                sleep(500);
            }
            System.out.println("T1 erreicht");
            barrier1.await();

            while(!move(pos,target2)) {
                sleep(500);
            }
            barrier2.await();
            System.out.println(getName() + ": T2 erreicht");


            System.out.println(getName() + ": both targets reached ");
        }
        catch (InterruptedException | BrokenBarrierException e) {

        }
    }

    private boolean move (Point pos, Point target) {

        if(pos.x < target.x)
            pos.x++;

        if(pos.x > target.x)
            pos.x--;

        if(pos.y < target.y)
            pos.y++;

        if(pos.y > target.y)
            pos.y--;

        System.out.println(getName() + " move from " + pos + " to " + target);
        return pos.equals(target);
    }
}