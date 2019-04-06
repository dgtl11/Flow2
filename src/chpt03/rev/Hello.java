// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.54 - Hello.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;

public class Hello<T> {

    T t;
    public Hello(T t) { this.t = t; }
    public String toString() { return t.toString(); }
    public static void main(String[] args) {
        System.out.println(new Hello<String>("hi"));
        System.out.println(new Hello("there"));

    }

}