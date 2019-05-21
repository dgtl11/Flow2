// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - YouTube Lessons & Xmpls
 *  Kapitel: - 12 - Functional Programming in Java 8
 *
 *    Thema: - 12.0 - Lambdas & Streams
 *
 *  Listing: - 12.0.01 - FPinJava8.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package functionalProgramming;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FPinJava8 {
    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        // external Iterator

/*        for(int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
*/

/*        for(int e : values) {
            System.out.println(e);
        }
*/

        // internal iterator

/*        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });
*/

//        values.forEach((Integer value) -> System.out.println(value));

//        values.forEach(value-> System.out.println(value));

//        values.forEach(value -> System.out.println(value));

        values.forEach(System.out::println);

    }
}