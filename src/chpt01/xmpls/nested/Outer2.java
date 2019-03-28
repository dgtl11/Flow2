// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.2 - Local Inner Classes
 *
 *  Listing: - 1.07.25 - Outer2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class Outer2 {
    private int length = 5;
    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                System. out .println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.calculate();
    }

    // What is effectively final ?
    public void isItFinal() {
        int one = 20;       // only this is
        int two = one;
        two++;
        int three;
        if ( one == 4) three = 3;
        else three = 4;
        int four = 4;
        class Inner { }
        four = 5;
    }

}