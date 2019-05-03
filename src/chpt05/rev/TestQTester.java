// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.6 - Review Questions
 *
 *  Listing: - 05.6.31 - TestQTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.rev;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestQTester {
    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~ 01 ~~~~~~~~~~~~~~~~~~~~~~");

        // ZonedDateTime zd = ZonedDateTime.parse("2020-05-04T08:05:00");      // ParseException
        // System.out.println(zd.getMonth() + " " + zd.getDayOfMonth());

        System.out.println("~~~~~~~~~~~~~~~~~~~ 02 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalTime t1 = LocalTime.of(9,0);
        LocalTime t2 = LocalTime.of(10,5);

        LocalTime t3 = t1.plus(65, ChronoUnit.MINUTES);
        LocalTime t4 = t1.plusMinutes(65);
        // LocalTime t5 = t1.plusHours(1);
        // LocalTime t6 = t1.plusDays(1);
        LocalTime t7 = t1.plus(Duration.ofMinutes(65));

        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t7);

        System.out.println("~~~~~~~~~~~~~~~~~~~ 03 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate d1 = LocalDate.of(2018, 1, 1);
        LocalDate d2 = LocalDate.of(2018, 6, 15);

        Period r = Period.between(d1, d2);
        System.out.println("Months and days: " + r.getMonths() + ", " + r.getDays());

        System.out.println("~~~~~~~~~~~~~~~~~~~ 04 ~~~~~~~~~~~~~~~~~~~~~~");

        ZonedDateTime nowzdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Pacific"));

        ZonedDateTime berlinZdt = nowzdt.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        ZonedDateTime berli2Zdt = ZonedDateTime.ofInstant(nowzdt.toInstant(), ZoneId.of("Europe/Berlin"));

        System.out.println("~~~~~~~~~~~~~~~~~~~ 05 ~~~~~~~~~~~~~~~~~~~~~~");

        ZonedDateTime totalityUTC = ZonedDateTime.of(LocalDateTime.of(2019, 7, 2, 16, 55), ZoneId.of("Z"));
        ZonedDateTime totalitySanJuan = totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        System.out.println(totalitySanJuan);

        System.out.println("~~~~~~~~~~~~~~~~~~~ 06 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 07 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 08 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 09 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 10 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDateTime now = LocalDateTime.of(2017,10,27,14,22,54,0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");     // L1
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        System.out.println("~~~~~~~~~~~~~~~~~~~ 11 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate d11 = LocalDate.of(2017, Month.NOVEMBER, 28);
        System.out.print(d11 + ", ");
        LocalDate d22 = d11.with(TemporalAdjusters.lastDayOfYear());
        System.out.print(d22 + ", ");
        LocalDate d33 = d11.plusDays(3).with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.print(d33 + ", ");
        LocalDate d44 = d11.minusMonths(11).with(TemporalAdjusters.firstDayOfNextYear());
        System.out.print(d44 + ", ");
        LocalDate d55 = LocalDate.ofEpochDay(d11.plusDays(27).toEpochDay());
        System.out.print(d55 + ", ");
        LocalDate d66 = d11.minus(Period.ofDays(5));
        System.out.println(d66);

        System.out.println("~~~~~~~~~~~~~~~~~~~ 12 ~~~~~~~~~~~~~~~~~~~~~~");

        ZoneId zid = ZoneId.of("US/Eastern");   // GMT-5:00
        Instant i = Instant.now();
        ZonedDateTime zdt = i.atZone(zid);
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));

    }
}