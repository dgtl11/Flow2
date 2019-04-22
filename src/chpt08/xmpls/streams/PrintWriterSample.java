// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.3 - working with I/O-Streams
 *
 *  Listing: - 08.3.08 - PrintWriterSample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// syntax
// public PrintWriter format(String format, Object args. . .)
// public PrintWriter printf(String format, Object args. . .)

// print()
// PrintWriter out = new PrintWriter("zoo.log");
// out.print(5); // PrintWriter method
// out.write(String.valueOf(5)); // Writer method
// out.print(2.0); // PrintWriter method
// out.write(String.valueOf(2.0)); // Writer method
// Animal animal = new Animal();
// out.print(animal); // PrintWriter method
// out.write(animal==null ? "null": animal.toString()); // Writer method

public class PrintWriterSample {
    public static void main(String[] args) throws IOException {
        File source = new File("zoo.log");
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(source)))) {
            out.print("Today's weather is: ");
            out.println("Sunny");
            out.print("Today's temperature at the zoo is: ");
            out.print(1/3.0);
            out.println('C');
            out.format("It has rained 10.12 inches this year");
            out.println();
            out.printf("It may rain 21.2 more inches this year");
        }
    }

}