// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.18 - r09CheetahManager.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

// need to implement methods

interface CanWalk {

    default void walk() { System.out.println("Walking"); }
}
interface CanRun {

   public default void walk() { System.out.println("Walking"); }

    public abstract void run();
 }
public interface r10CanSprint extends CanWalk, CanRun {

    void sprint();

    @Override
    default void walk() {

    }

    @Override
    default void run() {

    }
}