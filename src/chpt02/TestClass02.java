// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns and Principles
 *
 *    Thema: - 2.0 -
 *
 *  Listing: - 2.0.00 - TestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt02;

import java.util.Arrays;
import java.util.List;

public class TestClass02 {

    public static void main(String[] args) {

        List<StringBuilder> messages = Arrays.asList(new StringBuilder(), new StringBuilder());
        messages.stream().forEach(s->s.append("helloworld"));
        messages.forEach(s->{
            s.insert(5,",");
            System.out.println(s);
        });
        
    }
}

