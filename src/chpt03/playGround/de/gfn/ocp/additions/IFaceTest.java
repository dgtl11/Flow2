// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.16 - IFaceTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;


public class IFaceTest {
    public static void main(String[] args) {

        ClassA a = new ClassA();
        System.out.println(a.NAME);
        // System.out.println(a.staticMachWas());

    }
}

interface InterA {

    // auto public static final
    String NAME = "Peter";      // müssen in iface immer direkt
                                // nicht in static {} , {} , oder constructor
    // public
    static void staticMachWas() {
        System.out.println("static");
    }

    // public
    default void defaultMachWas() {
        System.out.println("default");
    }

    void abstractMachWas();
}

class ClassA implements InterA {
    @Override
    public void abstractMachWas() {

    }
}

