// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.1 - Dates Times
 *
 *  Listing: - 05.1.03 - PeriodDurationTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.datesNTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodDurationTest {


    // Periods
    /*
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        performAnimalEnrichment(start, end);
    }
    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {            // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1);          // add a month

        } }
*/

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1);         // create a period
        performAnimalEnrichment(start, end, period);
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {        // uses the generic period

        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period);               // adds the period

        }
    }

    public static void createPeriods() {
        // There are five ways to create a Period class:
        Period annually = Period.ofYears(1);                        // every 1 year
        Period quarterly = Period.ofMonths(3);                      // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3);                 // every 3 weeks
        Period everyOtherDay = Period.ofDays(2);                    // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7);    // every year and 7 days

        // tricky sh*t
        Period wrong = Period.ofYears(1).ofWeeks(1);        // every week
        // -->
        Period wrongagain = Period.ofYears(1);
        wrongagain = Period.ofWeeks(1);

        System.out.println(Period.of(0, 20, 47)); // P20M47D

        System.out.println(Period.ofWeeks(3));      // P21D

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Period period = Period.ofMonths(1);
        System.out.println(date.plus(period));          // 2015–02–20
        System.out.println(dateTime.plus(period));      // 2015–02–20T06:15
        // System.out.println(time.plus(period));       // UnsupportedTemporalTypeException

    }

    public static void createDurations() {

        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        Duration everyMilli = Duration.ofMillis(1);         // PT0 .001 S
        Duration everyNano = Duration.ofNanos(1);           // PT0 .000000001 S

        Duration daily2 = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly2 = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano2 = Duration.of(1, ChronoUnit.NANOS);

        // for Differences
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two));// 1

        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
        System.out.println(ChronoUnit.MINUTES.between(one, date)); // DateTimeException
    }

    public static void usingDurations() {
        LocalDate date = LocalDate.of(2015, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Duration duration = Duration.ofHours(6);
        System.out.println(dateTime.plus(duration)); // 2015–01–20T12:15
        System.out.println(time.plus(duration));// 12:15

        // System.out.println(date.plus(duration));  // UnsupportedTemporalException

        LocalDate date2 = LocalDate.of(2015, 1, 20);
        LocalTime time2 = LocalTime.of(6, 15);
        LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
        Duration duration2 = Duration.ofHours(23);
        System.out.println(dateTime2.plus(duration2)); // 2015–01–21T05:15
        System.out.println(time2.plus(duration2));// 05:15

        // System.out.println(date2.plus(duration2));  // UnsupportedTemporalException

        // period and duration of same time
        LocalDate date3 = LocalDate.of(2015, 5, 25);
        Period period3 = Period.ofDays(1);
        Duration days3 = Duration.ofDays(1);

        System.out.println(date3.plus(period3)); // 2015–05–26
        System.out.println(date3.plus(days3)); // Unsupported unit: Seconds


    }
}