// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.39 - Otter.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;

public interface Otter {
    default void play() { }
}
class RiverOtter implements Otter {
    @Override public boolean equals(Object o) { return false; }
    // @Override public boolean equals(Otter o) { return false; }
    @Override public int hashCode() { return 42; }
    // @Override public long hashCode() { return 42; }
    @Override public void play() { }
    // @Override void play() { }
}