// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test 05
 *
 *  Listing: - 11.0.05 - EtsTest05.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

class A {
    char  c;
    A(char c) { this.c = c;}
}

class B extends A {
    char c = 'a';
    B() { super('b');}
    class C extends A {
        char c = 'c';
        C() {
            super('d');
            System.out.println(B.this.c);
            System.out.println(C.this.c);
            System.out.println(super.c);

        }
    }
}

public class EtsTest05 {
    public static void main(String[] args) {

        B.C obj = new B().new C();

    }
}