// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.8 - Review Questions
 *
 *  Listing: - 4.0.00 - TestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.rev;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class TestClass {
    public static void main(String[] args) {

        System.out.println("Q01:");

        Stream<String> stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));

        System.out.println("################################################");

        System.out.println("Q02:");
        /*
        Predicate<? super String> predicate2 = s -> s.startsWith("g");
        Stream<String> stream1 = Stream.generate(() -> "growl! ");
        Stream<String> stream2 = Stream.generate(() -> "growl! ");
        boolean b1 = stream1.anyMatch(predicate2);
        boolean b2 = stream2.allMatch(predicate2);
        System.out.println(b1 + " " + b2);                  // hangs
        */
        System.out.println("################################################");
        System.out.println("Q03:");
        /*
        Predicate<? super String> predicate3 = s -> s.length() > 3;
        Stream<String> stream3 = Stream.iterate("-", (s) -> s + s);
        boolean b13 = stream.noneMatch(predicate3);
        boolean b23 = stream.anyMatch(predicate3);
        System.out.println(b13 + " " + b23);                // exception
        */
        System.out.println("################################################");
        System.out.println("Q04:");

        System.out.println("################################################");
        System.out.println("Q05:");

        System.out.println("################################################");
        System.out.println("Q06:");
        Stream<String> s = Stream.generate(() -> "meow");
        boolean match = s.allMatch(String::isEmpty);
        System.out.println(match);

        // A. allMatch  / geht
        // B. anyMatch  / fail
        // C. findAny   / fail
        // D. findFirst / fail
        // E. noneMatch / fail

        System.out.println("################################################");
        System.out.println("Q07:");
        /* is a Method / needs to be in class / not main meth
        private static List<String> sort(List<String> list) {
            List<String> copy = new ArrayList<>(list);
            Collections.sort(copy, (a, b) -> b.compareTo(a));
            return copy;
        }
        */

        System.out.println("################################################");
        System.out.println("Q08:");

        System.out.println("################################################");
        System.out.println("Q09:");
        LongStream ls = LongStream.of(1, 2, 3);
        OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();
        // what can be added so it produces no output
        // A. if (opt.isPresent()) System.out.println(opt.get());
        // B. if (opt.isPresent()) System.out.println(opt.getAsLong());  // geht
        // C. opt.ifPresent(System.out.println)
        // D. opt.ifPresent(System.out::println)

        if (opt.isPresent()) System.out.println(opt.getAsLong());
        // opt.ifPresent(System.out::println)

        System.out.println("################################################");
        System.out.println("Q10:");
        Stream.generate(() -> "1")

                .limit(10)                      // N
                .peek(System.out::println)      // O
                .filter(x -> x.length() > 1)    // L
                .forEach(System.out::println)   // M
                ;

        System.out.println("################################################");
        System.out.println("Q11:");
        Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.joining());

        System.out.println("################################################");
        System.out.println("Q12:");

        System.out.println("################################################");
        System.out.println("Q13:");
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
        // Stream.of(l1, l2, l3).map(x -> x + 1)
           //      .flatMap(x -> x.stream()).forEach(System.out::print);

        System.out.println("################################################");
        System.out.println("Q14:");
        Stream<Integer> s1 = Stream.of(1);
        IntStream is = s1.mapToInt(x -> x);
        // DoubleStream ds = s1.mapToDouble(x -> x);        // exception
        // Stream<Integer> s2 = ds.mapToInt(x -> x);        // compiler Error
        // s2.forEach(System.out::print);

        System.out.println("################################################");
        System.out.println("Q15:");

        System.out.println("################################################");
        System.out.println("Q16:");
        Stream<String> s2 = Stream.empty();
        Stream<String> s22 = Stream.empty();
        Map<Boolean, List<String>> p = s2.collect(
                Collectors.partitioningBy(b -> b.startsWith("c")));
        Map<Boolean, List<String>> g = s22.collect(
                Collectors.groupingBy(b -> b.startsWith("c")));
        System.out.println(p + " " + g);

        System.out.println("################################################");
        System.out.println("Q17:");

        System.out.println("################################################");
        System.out.println("Q18:");
        DoubleStream s3 = DoubleStream.of(1.2, 2.4);
        s3.peek(System.out::println).filter(x -> x > 2).count();

        System.out.println("################################################");
        System.out.println("Q19:");

        System.out.println("################################################");
        System.out.println("Q20:");
        List<Integer> l = IntStream.range(1, 6)
                .mapToObj(i -> i).collect(Collectors.toList());
        l.forEach(System.out::println);
        // -->>
        // IntStream.range(1, 6);
        IntStream.range(1, 6)                       // B
                .forEach(System.out::println);

        // IntStream.range(1, 6)                       // C Compiler Error
        //        .mapToObj(1 -> i)
        //        .forEach(System.out::println);

        System.out.println("################################################");
        System.out.println("Ende Review Questions 04");
    }

    // Q07:
    private static List<String> sort(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy, (a, b) -> b.compareTo(a));
        return copy;
    }
}