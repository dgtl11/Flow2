// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.8 - Review Q
 *
 *  Listing: - 09.8.20 - RevTestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.rev;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EtsRevTestClass {
    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println(" 01 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 02 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 03 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 04 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 05 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 06 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 07 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 08 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 09 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        System.out.println(" 10 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



    }

    public static void writeData() {
    Path p1 = Paths.get("c:\\company\\records\\customers.dat");

    //LINE 20  - INSERT CODE HERE
        Path p2 = p1.resolveSibling("clients.dat");
        try (
                BufferedReader br = new BufferedReader(new FileReader(p1.toFile()));
                BufferedWriter bw = new BufferedWriter(new FileWriter(p2.toFile()))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}