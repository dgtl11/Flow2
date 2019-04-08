// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.12 - AdditionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;

import assessmentTest.UnaryOp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class AdditionTest {

    private static int i2;

    public static void main(String[] args) {

        MachWasInterface mwi = new MachWasInterface() {
            @Override
            public void machWas() {
                throw new UnsupportedOperationException("Not supported yet. ");
            }
        } ;

        int i = 10;

        MachWasInterface mwi2 = () -> System.out.println("Moin" + i + i2);
        Object o2 = mwi2;

        // i++;    // not effectively final
        i2++;
        // Object o = () -> System.out.println("Moin");


        // Consumer<String> c1 = (w) -> System.out.print();     / compiler error
        Consumer<String> c1 = (w) -> System.out.println(w.toLowerCase());
        Consumer<String> c2 = (w) -> System.out.println("---" + w + "----");
        c1.accept("HALLO WELT");
        c1.andThen(c2).accept("HALLO WELT");

        System.out.println("----------------------------------------");

        // function
        Function<Double, String> f1 = (d) -> String.format("%.2f", d);
        // f1.compose((d) -> d * 10).apply(10.25);
        Function<String, String> f2 = (d) -> String.format("%s €", d);
        System.out.println(f1.andThen(f2).apply(10.25));

        BiFunction<Integer, Double, Double> bf1 = AdditionTest::machWas;
        bf1.apply(10,2.5);

        AdditionTest t1 = new AdditionTest();
        BiFunction<String, String, String> bf2 = t1::machWas;

        BiFunction<Integer, Double, Double> bf3 = AdditionTest::machWasAnderes;

        Function<String, Integer> f4 = Integer::valueOf;
        System.out.println(f4.apply("2000") + 100);     // wichtig das sie schon irgendwo ist

        System.out.println("----------------------------------------");

        // supplier
        Supplier<String> sup1 = String::new;

        Supplier<AdditionTest> sup2 = AdditionTest::new;

        Supplier<LocalDate> now = () -> LocalDate.now();

        System.out.println("----------------------------------------");

        BiPredicate<Integer, Integer> p1 = AdditionTest::checkInt;

        System.out.println(p1.test(150, 150));

        Integer a = 100;
        int b = 27;

        System.out.println(p1.test(127, a + b));

        System.out.println("-------------------------------------------");

        Predicate<Integer> p2 = (intVal) -> intVal > 10;
        Predicate<Integer> p3 = (intVal) -> intVal < 80;

        System.out.println(p2.test(15));

        List<Integer> list1 = new ArrayList(Arrays.asList(1,4,6,15,22,67,98,56,13,15,22,1,2,3));
        // list1.removeIf(p2);     // wirft alles raus was true ist - Verändert das Orginal
        list1.stream().filter(p2.and(p3)).forEach(System.out::println);

        System.out.println("----------------------------------------------");

        list1.stream().filter(p2.and(p3).negate()).forEach(System.out::println);
        System.out.println(list1);

        System.out.println("----------------------------------------------");

        UnaryOperator<String> uo1 = (w) -> w + "...";
        uo1.apply("Moin");

        System.out.println("----------------------------------------------");

        // specials
        IntConsumer ic1 = (i3) -> System.out.println(i3 + 2);

        LongToDoubleFunction ldf1 = (l) -> l * 2.5;
        ldf1.applyAsDouble(100);

        IntSupplier w6 = () -> (int) Math.floor(Math.random() *6) +1;
        System.out.println(w6.getAsInt());



    }

    static boolean checkInt(Integer i1, Integer i2) {
        return i1 == i2;
    }

    static Double machWas(Integer i, Double d) {
        return d * i;
    }

    static Double machWasAnderes(Integer i, Double d) {
        return d * i;
    }

    String machWas(String s1, String s2) {
        return s1.concat(s2);

    }

}

interface MachWasInterface {
    void machWas();

    @Override
    String toString();
}