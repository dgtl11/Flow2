// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - WhizLabs BigTest Test
 *
 *  Listing: - 11.0.02 - Co.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.temporal.ChronoField;

public class Co {

    public static void main(String[] args) throws IOException {

        Stream<Integer> intStream = Stream.of(1,7,15,22,19,8, 8, 38,99, 99, 75);
        // intStream.findAny().


        /*
        Path path = Paths.get("..\\myfile.txt");
        BasicFileAttributes at = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(at.isRegularFile());
        */

        // LocalDate.ofYearDay(2015,365);
        /*
        Stream<String> list = Stream.of("BB","CCC","AB","CCC").parallel();
        Optional<String> out = list.collect(Collectors.minBy(Comparator.comparing(String::length)));
        System.out.println(out);
        */
    }


    /*

    public static void main(String[] args) {
        Stream<String> streams = Stream.of("0ne", "two", "three");
        Optional<String> op = streams.filter(s -> s.length()>5).findFirst().flatMap(s -> Optional.of("4"));

        System.out.println(op);

    }
*/

    /*
    public static void main(String[] args) {
        Console con = System.console();
        char [] c = con.readPassword("Enter the PW: ");
        // System.out.write("Your Password is: ");
        for(int i : c) {
            System.out.write(i);
            System.out.flush();
        }
    }*/
}