// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - YouTube Lessons & Xmpls
 *  Kapitel: - 12 - Functional Programming in Java 8
 *
 *    Thema: - 12.0 - Lambdas & Streams
 *
 *  Listing: - 12.0.02 - FPinJava8_2.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package functionalProgramming;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FPinJava8_2 {

    // method is a function which belongs to a class or to an obj

    // a function has 4 things
    // 1. name
    // 2. return type
    // 3. parameter list
    // 4. body

    // lambdas exp
    // (parameter list) -> body

    public static void main(String[] args) {

        System.out.println("lesson one:  ");
        System.out.println();

//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("in another thread");
//            }
//        });

        Thread th = new Thread(() -> System.out.println("in another thread"));


        th.start();
        System.out.println("in main");

        System.out.println();
        System.out.println("lesson two:  ");
        System.out.println();


        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        // external Iterator

//        for(int i = 0; i < values.size(); i++) {
//            System.out.println(values.get(i));
//        }


//        for(int e : values) {
//            System.out.println(e);
//        }


        // internal iterator

//        values.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer value) {
//                System.out.println(value);
//            }
//        });

//        values.forEach((Integer value) -> System.out.println(value));

//        values.forEach(value-> System.out.println(value));

//        values.forEach(value -> System.out.println(value));

        values.forEach(System.out::println);


        System.out.println();
        System.out.println("lesson 3: ");
        System.out.println();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // find the total od double of even numbers

        // imperative Style
        int result = 0;
        for(int e : numbers) {
            if(e % 2 == 0) {
                result += e * 2;
            }
        }

        System.out.println(result);

        // more declarative style
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );


        System.out.println();
        System.out.println("lesson 4: ");
        System.out.println();

        List<Integer> nums = Arrays.asList(1,2,3);

        int factor = 2;     // must be effectivelly final
        // int[] factorAr = new int[] { 2 };

        nums.stream()
                .map(e -> e * factor)
                . forEach(System.out::println);

        // lambda has to close-over it defining scope looking for
        // the variable factor to bind to - closure

        // lambdas are stateless
        // closure has (immutable state)

        Stream<Integer> strm = nums.stream()
                                   .map(e -> e * factor);

        // factor = 4;      // cannot changes couse effectivelly final
        // factorAr[0] = 0; // would work, cause [] is final, but population not,
        //                      so -->  it's a really bad idea

        strm.forEach(System.out::println);


        System.out.println();
        System.out.println("lesson 5: ");
        System.out.println();

        // List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // get the double of sqrt root of even numbers

        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToDouble(Math::sqrt)
                        .sum()
        );

    }
}