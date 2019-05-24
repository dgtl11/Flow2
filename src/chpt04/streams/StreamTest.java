/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt04.streams;;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


/**
 *
 * @author tlubowiecki
 */
public class StreamTest {
    
    public static void main(String[] args) {



        // Stream von Integer-Objekten
        Stream<Integer> intStream = Stream.of(1,7,15,22,19,8, 8, 38,99, 99, 75);
        // intStream.toArray();
        // System.out.println(intStream.reduce(0, (a, b) -> a + b));
        // System.out.println(intStream.distinct().count());
        
        // System.out.println(intStream.findAny());
        System.out.println(intStream.findFirst());
        
        
        // Stream von primitiven ints
        int[] arr = {1,7,15,22,19,8,38,99,75};
        IntStream iStream = Arrays.stream(arr);
        
        Set<Integer> set = iStream.filter((i) -> i > 10).boxed().collect(Collectors.toSet());
        
        
        System.out.println("-----------");
        
        Collection<Integer> coll = new ArrayList<>(Arrays.asList(1,7,15,22,19,8,1, 19, 22, 38,99,75));
        intStream = coll.stream();
        intStream.distinct().sorted().skip(2).limit(5).forEach(System.out::println);
        
        System.out.println("-----------");
        
        Random rand = new Random();
        // Generiert einen endlosen Stream von Integer-Objekten
        intStream = Stream.generate(() -> rand.nextInt(10));
        
        // Erzeugt ein Stream mit primitiven ints von 1 bis 100
        iStream = IntStream.range(1, 100);
        //iStream.peek((i) -> System.out.print(i + ": ")).map((i) -> i * 10).forEach(System.out::println);
        //iStream = iStream.peek((i) -> System.out.print(i + ": ")).map((i) -> i * 10);
        
        System.out.println("---------");
        
        System.out.println(iStream.max().getAsInt());
        
        // IllegalStateException, da der Stream bereits verarbeitet ist
        // iStream.forEach(System.out::println);
        
        System.out.println("-----------");
        
        // Erzeugt ein Stream von Wörtern
        Stream<String> words = Stream.of("Das ist ein Haus von Nikigraus".split(" "));
        
        // Erzeugt ein Stream von Buchstaben als ints
        IntStream chars = "Das ist ein Haus von Nikigraus".chars();
        chars.filter((i) -> i > 100 && i < 150).forEach((i) -> System.out.print((char)i));
        
        System.out.println("\n-----------");
        
        try {
            Stream<String> strStream = Files.lines(Paths.get("text.txt"));
            strStream.filter((l) -> l.length() > 20).forEach(System.out::println);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("\n-----------");
        
        ArrayList<String> al = new ArrayList<>(Arrays.asList("Peter", "Bob", "Justus"));
        
        // Gibt es mind. einen
        // System.out.println(al.stream().anyMatch((s) -> s.startsWith("P")));
        
        // Gibt kein element
        // System.out.println(al.stream().noneMatch((s) -> s.startsWith("Q")));
        
        // Entsprechen alle Elemente der Vorgabe?
        System.out.println(al.stream().allMatch((s) -> s.length() >= 3));
        
        System.out.println("\n-----------");
        
        LongStream lStream = LongStream.range(1, 100);
        System.out.println(lStream.sum());

        System.out.println("\n-----------");

        al.stream().mapToInt(s -> s.length()).forEach(System.out::println);

        System.out.println("\n-----------");

        List<String> namen = Arrays.asList("Bruce", "Peter", "Clark");

        List<List<String>> List2d = Arrays.asList(al, namen);

        List2d.stream().flatMap(l -> l.stream()).distinct().forEach(System.out::println);



    }
}
