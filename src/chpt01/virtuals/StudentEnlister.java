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
 *  Listing: - 1.3.30 - StudentEnlister.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.virtuals;

public class StudentEnlister {
    public static void main(String[] args) {
        
        Student Max = new Student();

        NetworkStudent Paul = new NetworkStudent();

        JavaStudent Marry = new JavaStudent();

        Max.learn();
        System.out.println(Max.difficulty);

        Paul.learn();
        System.out.println(Max.difficulty);

        Marry.learn();
        System.out.println(Max.difficulty);


    }
}