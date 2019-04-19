// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.1 - Dates Times
 *
 *  Listing: - 05.1.02 - DateTimeTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.datesNTimes;

import java.time.*;

public class DateTimeTest {
    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        // this is new @ OCP
        System.out.println(ZonedDateTime.now());

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        Month month = Month.JANUARY;
        // boolean b1 = month == 1;                // DOES NOT COMPILE
        // boolean b2 = month == Month.APRIL;      // false

        LocalTime time1 =LocalTime.of(6, 15);                   // hour and minute
        LocalTime time2 =LocalTime.of(6, 15, 30);           // + seconds
        LocalTime time3 =LocalTime.of(6, 15, 30, 200);  // + nanoseconds
/*
        public static LocalTime of(int hour, int minute)
        public static LocalTime of(int hour, int minute, int second)
        public static LocalTime of(int hour, int minute, int second, int nanos)

*/
        // combine them
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
/*
        public static LocalDateTime of(int year, int month,
        int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, int month,
        int dayOfMonth, int hour, int minute, int second)
        public static LocalDateTime of(int year, int month,
        int dayOfMonth, int hour, int minute, int second, int nanos)
        public static LocalDateTime of(int year, Month month,
        int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, Month month,
        int dayOfMonth, int hour, int minute, int second)
        public static LocalDateTime of(int year, Month month,
        int dayOfMonth, int hour, int minute, int second, int nanos)
        public static LocalDateTime of(LocalDate date, LocalTime time)
  */

        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20, 6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
/*
        public static ZonedDateTime of(int year, int month,
        int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
        public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
   */

        // finding a time zone
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("US") || z.contains("America"))
                .sorted().forEach(System.out::println);

        // LocalDate d = new LocalDate(); // DOES NOT COMPILE

        // LocalDate.of(2015, Month.JANUARY, 32); // throws DateTimeException


        // manipulating
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date);           // 2014–01–20

        date = date.plusDays(2);
        System.out.println(date);           // 2014–01–22

        date = date.plusWeeks(1);
        System.out.println(date);           // 2014–01–29

        date = date.plusMonths(1);
        System.out.println(date);           // 2014–02–28

        date = date.plusYears(5);
        System.out.println(date);           // 2019–02–28

        // backwards in time
        LocalDate dateagain = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(dateagain, time);
        System.out.println(dateTime);           // 2020–01–20T05:15

        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);           // 2020–01–19T05:15

        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime);           // 2020–01–18T19:15

        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime);           // 2020–01–18T19:14:30


        // or chain
        LocalDate dateagain2 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime timeagain2 = LocalTime.of(5, 15);
        LocalDateTime dateTimeagain2 = LocalDateTime.of(dateagain2, timeagain2)
                .minusDays(1).minusHours(10).minusSeconds(30);

        // dont get tricked
        LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20);
        date3.plusDays(10);                         // gets ignored
        System.out.println(date3);


        LocalDate date4 = LocalDate.of(2020, Month.JANUARY, 20);
        // date4 = date4.plusMinutes(1);         // DOES NOT COMPILE

    }

}