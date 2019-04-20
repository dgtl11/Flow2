// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.2 - Try with Resources
 *
 *  Listing: - 06.2.02 - UsingTwR.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.withResources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.System.out;

public class UsingTwR {

    public void oldApproach(Path path1, Path path2) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            out.write(in.readLine());
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    public void newApproach(Path path1, Path path2) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {
            out.write(in.readLine());
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = null;
        BufferedWriter out = null;

        // appears to guarantee resource closure, but in fact it does not
        try {

        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }

        // better implementation
        try {

        } finally {
            try {
                in.close();
            } catch (IOException e) {}
            try {
                out.close();
            } catch (IOException e) {}
        }


        // Basics
        try (Scanner s = new Scanner(System.in)) {
            s.nextLine();
        } catch(Exception e) {
           // s.nextInt(); // DOES NOT COMPILE not in scope
        } finally{
           // s.nextInt(); // DOES NOT COMPILE
        }



    }
}