// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.4 - Understanding Design Principles
 *             2.4.5 - Composing
 *
 *  Listing: - 2.4.04 - Penguin.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.principles;

public class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }
    public void kick() {
        this.webbedFeet.kick();
    }
}