// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test Uniqu
 *
 *  Listing: - 11.0.13 - EtsTestU.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.time.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class EtsTestU {
    public static void main(String[] args) {

       Stream<String> ss = Stream.of("a","b","c");
       String str = ss.collect(Collectors.joining(",", "-","+"));
       System.out.println(str);

       List<Integer> names = Arrays.asList(1,2,3);
       names.forEach(x->x=x+1);
       names.forEach(System.out::println);

        LocalDateTime ldt = LocalDateTime.of(2017, 06, 02, 6, 0, 0);  //Jun 2nd, 6AM.
        ZoneOffset nyOffset = ZoneOffset.ofHoursMinutes(-5, 0);
        ZoneId nyZone = ZoneId.of("America/New_York");
        OffsetDateTime nyOdt = ldt.atOffset(nyOffset);
        ZonedDateTime nyZdt = ldt.atZone(nyZone);
        Duration d = Duration.between(nyOdt, nyZdt); System.out.println(d);

    }
}