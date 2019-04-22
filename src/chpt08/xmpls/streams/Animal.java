// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.3 - working with I/O-Streams
 *
 *  Listing: - 08.3.06 - Animal.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable {
    private static final long serialVersionUID = 2L;
    private transient String name;
    private transient int age= 10;
    private static char type = 'C';
    {this.age = 14;}

    public Animal() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public char getType() { return type; }
    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}