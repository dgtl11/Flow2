// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.15 - r02EasternChipmunk.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

interface CanClimb {
    public abstract void climb();
}
interface CanClimbTrees extends CanClimb {}
abstract class Chipmunk implements CanClimbTrees {
    public abstract void chew();
}
public class r02EasternChipmunk extends Chipmunk {
    public void chew() { System.out.println("Eastern Chipmunk is Chewing"); }

    @Override
    public void climb() {

    }
}
