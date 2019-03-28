// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.1 - Member Inner Classes
 *
 *  Listing: - 1.07.22 - Outer.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
            }
        }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();
    }

    // other way to create inner class
    /*
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner(); // create the inner class
        inner.go();
    }
    */
}