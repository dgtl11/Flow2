// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.9 - ReviewQuestions
 *
 *  Listing: - 06.9.11 - AutocloseableFlow2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.rev;

import java.io.Closeable;
import java.io.*;
/*
public class AutocloseableFlow2 {
    static class Door implements AutoCloseable {
        public void close() {
            System.out.print("D");
            throw new RuntimeException();
        } }
    static class Window implements Closeable {
        public void close() {
            System.out.print("W");
            throw new RuntimeException();
        } }
    public static void main(String[] args) {
        try {
            Door d = new Door(); Window w = new Window()        // wrong here
        }                                                       // there
        {
            System.out.print("T");
        } catch (Exception e) {                                 // also that
            System.out.print("E");
        } finally {                                             // and this
            System.out.print("F");
        } } }
*/