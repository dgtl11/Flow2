// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.2 - Generic interfaces
 *
 *  Listing: - 2.2.07 - Shippable.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


import java.awt.*;

public interface Shippable<T>{

    void ship(T t);
}

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) { }
}

class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) { }
}

class ShippableCrate implements Shippable {
    public void ship(Object t) { }
}