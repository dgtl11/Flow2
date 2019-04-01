// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.1 - Reviewing OCA Collections
 *             2.1.4 - The Diamond Operator
 *
 *  Listing: - 2.1.01 - Doggies.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.diamond;

import java.util.*;
class Doggies {
    List<String> names;
    Doggies() {
        names = new ArrayList<>();      // matches instance variable declaration
    }
    public void copyNames() {
        ArrayList<String> copyOfNames;
        copyOfNames = new ArrayList<>(); // matches local variable declaration
    } }