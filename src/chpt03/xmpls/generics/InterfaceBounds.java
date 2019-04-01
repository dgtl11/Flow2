// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.5 - Bounds
 *                   - Upper-Bounded Wildcards
 *
 *  Listing: - 2.2.14 - InterfaceBounds.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;

import java.util.List;

interface Flyer {
    void fly();
}
class HangGlider implements Flyer { public void fly() {} }
class Goose implements Flyer { public void fly() {} }

public class InterfaceBounds {
    private void anyFlyer(List<Flyer> flyer) {}
    private void groupOfFlyers(List<? extends Flyer> flyer) {}
}