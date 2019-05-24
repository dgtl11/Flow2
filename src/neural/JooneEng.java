// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 12 - NeuralNets
 *
 *    Thema: - 12.0 -
 *
 *  Listing: - 12.0.0x - JooneEng.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package neural;

import assessmentTest.UnaryOp;
// import org.sqlite.*;
// import org.joone.*;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class JooneEng {

    public static void main(String[] args) {

        // write your own first neural net

        // Stream stream = Stream.of("10","20","30");
        // Optional<String> out = stream.anyMatch(s -> s.length()>2);
        // System.out.println(out);

        // Optional<String> ops = Optional.empty();

        /* UnaryOperator unaryOperator = new UnaryOperator() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };
        */

        String in = new String("1");
        Predicate<String> ins = Predicate.isEqual(in);
        System.out.println(ins.test("2"));

        LocalDate ld = LocalDate.of(2010,10,10);
        int days = ld.getDayOfMonth();
        System.out.println(days);

        Instant inst = Instant.now();
        // inst.get(ChronoField.);

        LocalTime lt = LocalTime.of(22,10);
        lt = lt.truncatedTo(ChronoUnit.HALF_DAYS);
        System.out.println(lt);

        LocalDate ld3 = LocalDate.ofYearDay(2016, 250);
        System.out.println(ld3.getMonthValue());

        Period p = Period.ofDays(2);
        p = p.multipliedBy(30);
        System.out.println(p.toTotalMonths());
    }

}