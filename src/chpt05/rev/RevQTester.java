// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.6 - Review Questions
 *
 *  Listing: - 05.6.30 - RevQTester.java
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
import java.util.Locale;
import java.util.ResourceBundle;

public class RevQTester {
    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~ 01 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 02 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 03 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 04 ~~~~~~~~~~~~~~~~~~~~~~");
/*
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle b = ResourceBundle.getBundle("Dolphins");
        b.getString("name");
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~ 05 ~~~~~~~~~~~~~~~~~~~~~~");
/*
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle b = ResourceBundle.getBundle("Dolphins", fr);
        b.getString("name");
        b.getString("age");
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~ 06 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 07 ~~~~~~~~~~~~~~~~~~~~~~");
/*
        LocalDate date = LocalDate.parse(
                "2018–04–30", DateTimeFormatter.ISO_LOCAL_DATE);
        date.plusDays(2);
        date.plusHours(3);                          // compile Error
        System.out.println(date.getYear() + " "
                + date.getMonth() + " "+ date.getDayOfMonth());
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~ 08 ~~~~~~~~~~~~~~~~~~~~~~");
/*
        LocalDate date8 = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date8.getYear() + " " + date8.getMonth()
                + " "+ date8.getDayOfMonth());

        // DateTimeException
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~ 09 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate date9 = LocalDate.of(2018, Month.APRIL, 30);
        date9.plusDays(2);
        date9.plusYears(3);
        System.out.println(date9.getYear() + " "
                + date9.getMonth() + " "+ date9.getDayOfMonth());

        System.out.println("~~~~~~~~~~~~~~~~~~~ 10 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDateTime d10 = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p10 = Period.of(1, 2, 3);
        d10 = d10.minus(p10);
        DateTimeFormatter f10 = DateTimeFormatter.
                ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(d10.format(f10));

        System.out.println("~~~~~~~~~~~~~~~~~~~ 11 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDateTime d11 = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p11 = Period.ofDays(1).ofYears(2);
        d11 = d11.minus(p11);
        DateTimeFormatter f11 = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f11.format(d11));

        System.out.println("~~~~~~~~~~~~~~~~~~~ 12 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 13 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate date13 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time13 = LocalTime.of(1, 30);
        ZoneId zone13 = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime113 = ZonedDateTime.of(date13, time13, zone13);
        ZonedDateTime dateTime213 = dateTime113.plus(1, ChronoUnit.HOURS);
        long hours = ChronoUnit.HOURS.between(dateTime113, dateTime213);
        int clock1 = dateTime113.getHour();
        int clock2 = dateTime213.getHour();
        System.out.println(hours + "," + clock1 + "," + clock2);

        System.out.println("~~~~~~~~~~~~~~~~~~~ 14 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 15 ~~~~~~~~~~~~~~~~~~~~~~");

        String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
        String m2 = Duration.ofMinutes(1).toString();
        String s = Duration.of(60, ChronoUnit.SECONDS).toString();
        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();
        System.out.println( m1 == m2 );
        System.out.println( m1.equals(m2) );        // b
        System.out.println( m1.equals(s) );         // c
        System.out.println( d == p );
        System.out.println( d.equals(p) );

        // A. m1 == m2
        // B. m1.equals(m2)
        // C. m1.equals(s)
        // D. d == p
        // E. d.equals(p)

        System.out.println("~~~~~~~~~~~~~~~~~~~ 16 ~~~~~~~~~~~~~~~~~~~~~~");

        LocalDate date16 = LocalDate.now();
        LocalTime time16 = LocalTime.now();
        LocalDateTime dateTime16 = LocalDateTime.now();
        ZoneId zoneId16 = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime16 = ZonedDateTime.of(dateTime16, zoneId16);
        long epochSeconds = 0;
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.ofEpochSecond(epochSeconds);
        // Instant instant3 = date16.toInstant();      // cannot resolve
        // Instant instant4 = dateTime16.toInstant();  // missing arg
        // Instant instant5 = time16.toInstant();      // cannot resolve
        Instant instant6 = zonedDateTime16.toInstant();

        // A. Instant.now()
        // B. Instant.ofEpochSecond(epochSeconds)
        // C. date.toInstant()
        // D. dateTime.toInstant()
        // E. time.toInstant()
        // F. zonedDateTime.toInstant()


        System.out.println("~~~~~~~~~~~~~~~~~~~ 17 ~~~~~~~~~~~~~~~~~~~~~~");
/*
        private static void print(Properties props) {
            System.out.println(props.get("veggies", "none")
                    + " " + props.get("omni", "none"));
        }
*/
        System.out.println("~~~~~~~~~~~~~~~~~~~ 18 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 19 ~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~ 20 ~~~~~~~~~~~~~~~~~~~~~~");

    }
}