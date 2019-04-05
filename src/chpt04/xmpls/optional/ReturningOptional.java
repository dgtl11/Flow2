// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.3 - Returning an Optional
 *
 *
 *  Listing: - 4.3.02 - ReturningOptional.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.xmpls.optional;

import java.util.Optional;

public class ReturningOptional {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        // Calling the method shows what is in our two boxes:
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average());                // Optional.empty

        // check if a value is there and/or get it out of the box. Here’s one way to do that:
        Optional<Double> opt = average(90, 100);
        if (opt.isPresent())
            System.out.println(opt.get()); // 95.0

        // if we didn’t do the check and the Optional was empty?
        // Optional<Double> opt2 = average();
        // System.out.println(opt2.get()); // bad -> exception

        Object value = null;
        Optional o = (value== null) ? Optional.empty(): Optional.of(value);
        Optional o2 = Optional.ofNullable(value);

        // If value is null, o is assigned the empty Optional. Otherwise, we wrap the value. Since
        //this is such a common pattern, Java provides a factory method to do the same thing:
        Optional o3 = Optional.ofNullable(value);

        // we can specify a Consumer to be run when there is
        // a value inside the Optional. When there isn’t, the method simply skips running the
        // Consumer:
        Optional<Double> opt2 = average(90, 100);
        opt2.ifPresent(System.out::println);

        // what to do if a value isn’t present. There
        // are three choices: but they give exceptions
        // Optional<Double> opt3 = average();
        // System.out.println(opt3.orElse(Double.NaN));
        // System.out.println(opt3.orElseGet(() -> Math.random()));
        // System.out.println(opt3.orElseThrow(() -> new IllegalStateException()));

        // System.out.println(opt.orElseGet(
        //         () -> new IllegalStateException())); // DOES NOT COMPILE
        // opt is an Optional<Double>. This means the Supplier must return a Double. Since this
        // supplier returns an exception, the type does not match.

        Optional<Double> opt4 = average(90, 100);
        System.out.println(opt4.orElse(Double.NaN));
        System.out.println(opt4.orElseGet(() -> Math.random()));
        System.out.println(opt4.orElseThrow(() -> new IllegalStateException()));
    }
}