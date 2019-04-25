// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.4 - Presenting the New Stream Methods
 *             09.5 - Comparing Legacy File and NIO.2 Methods
 *
 *  Listing: - 09.4.07 - NewStreamsTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.xmpls.newStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewStreamsTester {
    public static void main(String[] args) throws IOException {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // walking a Directory
        Path path = Paths.get("/bigcats");
        try {
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        // /bigcats/version1/backup/Lion.java
        /// bigcats/version1/Lion.java
        /// bigcats/version1/Tiger.java
        /// bigcats/Lion.java

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Searching a Directory
        Path path2 = Paths.get("/bigcats");
        long dateFilter = 1420070400000l;
        try {
            Stream<Path> stream = Files.find(path2, 10,
                    (p,a) -> p.toString().endsWith(".java")
                            && a.lastModifiedTime().toMillis()>dateFilter);
            stream.forEach(System.out::println);
        } catch (Exception e) {
            // Handle file I/O exception...
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Listing Directory Contents
        try {
            Path path3 = Paths.get("ducks");
            Files.list(path3)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        // /zoo/ducks/food.txt
        // /zoo/ducks/food-backup.txt
        // /zoo/ducks/weight.txt

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Printing File Contents
        Path path4 = Paths.get("/fish/sharks.log");
        try {
            Files.lines(path4).forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        Path path5 = Paths.get("/fish/sharks.log");
        try {
            System.out.println(Files.lines(path5)
                            .filter(s -> s.startsWith("WARN "))
                            .map(s -> s.substring(5))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            // Handle file I/O exception...
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Files.readAllLines() vs. Files.lines()

        Files.readAllLines(Paths.get("birds.txt")).forEach(System.out::println);
        Files.lines(Paths.get("birds.txt")).forEach(System.out::println);

        // Files.readAllLines(path).filter(s -> s.length()>2).forEach(System.out::println);
        Files.lines(path).filter(s -> s.length()>2).forEach(System.out::println);


        // The first line does not compile because the filter() operation cannot be applied to a
        // Collection without first converting it to a Stream using the stream() method.


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


    }
}