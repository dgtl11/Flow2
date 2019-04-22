// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.2 - Introducing Streams (I/O-Streams)
 *
 *  Listing: - 08.2.03 - IOStreamsTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.streams;

import java.io.*;

public class IOStreamsTester {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // high-level stream is built on top of another stream using wrapping
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader("zoo-data.txt"))) {
            System.out.println(bufferedReader.readLine());
        }

        // High-level streams can take other high-level streams as input.
        /*
        try (ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("zoo-data.txt")))) {
            System.out.println(objectStream.readObject());
        }

         */

        // new BufferedInputStream(new FileReader("zoo-data.txt"));        // DOES NOT COMPILE
        // new BufferedWriter(new FileOutputStream("zoo-data.txt"));       // DOES NOT COMPILE
        // new ObjectInputStream(new FileOutputStream("zoo-data.txt"));    // DOES NOT COMPILE
        // new BufferedInputStream(new InputStream());                     // DOES NOT COMPILE

        // first two examples do not compile because they mix Reader / Writer classes with
        // InputStream / OutputStream classes, respectively. The third example does not compile
        // because we are mixing an OutputStream with an InputStream . Although it is possible to
        // read data from an InputStream and write it to an OutputStream , wrapping the stream is
        // not the way to do so.
        // last example does not compile because InputStream is an
        // abstract class, and therefore you cannot instantiate an instance of it.


        // marking the Stream
        // InputStream is = ...
        InputStream is = new FileInputStream("zoo-data.txt");
        System.out.print ((char)is.read());
        if(is.markSupported()) {
            is.mark(100);
            System.out.print((char)is.read());
            System.out.print((char)is.read());
            is.reset();
        }
        System.out.print((char)is.read());
        System.out.print((char)is.read());
        System.out.print((char)is.read());

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // skipping over Data
        // InputStream is = . . .
        InputStream is2 = new FileInputStream("zoo-tigers.txt");
        System.out.print ((char)is2.read());
        is2.skip(2);
        is2.read();
        System.out.print((char)is2.read());
        System.out.print((char)is2.read());



    }
}