/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 -
 *
 *    Thema: - 1.3 - Virtual Methods
 *
 *  Listing: - 1.3.33 - JavaStudent.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.virtuals;

public class JavaStudent {

    public int difficulty = 3;

    public void learn() {
        learnStuff();
    }

    public void learnStuff() {
        System.out.println("java is even cooler.. ");
    }

}