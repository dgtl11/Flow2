// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.16 - r03ArcticMountainClimb.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

interface Climb2 {
    public int climb();
}
abstract class Swim {
    public abstract Object swim(double speed, int duration);
}

public interface r03ArcticMountainClimb extends MountainClimb {
    // default method must have body
    public default int getSpeed(){
        return 0;
    }


}
interface MountainClimb extends Climb2 {}