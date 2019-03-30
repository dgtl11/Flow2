// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.34 - r20CanFly.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

public interface r20CanFly {
    void fly();
}
interface HasWings {
    public abstract Object getWingSpan();
}
abstract class Falcon implements r20CanFly, HasWings {
}

