// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.1 - Member Inner Classes
 *
 *  Listing: - 1.07.23 - A.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class A {
    private int x = 10;
    class B {
        private int x = 20;
        class C {
            private int x = 30;
            public void allTheX() {
                System.out.println(x);          // 30
                System.out.println(this.x);     // 30
                System.out.println(B.this.x);   // 20
                System.out.println(A.this.x);   // 10
            } } }
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }
}