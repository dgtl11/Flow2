// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.1 - Dates Times
 *
 *  Listing: - 05.1.04 - InstantsTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.datesNTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class InstantsTest {

    public static void main(String[] args) {

        // time benchmark
        Instant now = Instant.now();
        // do something time consuming
        Instant later = Instant.now();

        Duration duration = Duration.between(now, later);
        System.out.println(duration.toMillis());


    }

    public static void  turnZonedToInstant () {
        LocalDate date = LocalDate.of(2015, 5, 25);
        LocalTime time = LocalTime.of(11, 55, 00);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
        Instant instant = zonedDateTime.toInstant() ; // 2015–05–25T15:55:00Z
        System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
        System.out.println(instant); // 2015–05–25T15:55:00Z

        // or with epoch
        // Instant instant2 = Instant.ofEpochSecond(epochSeconds);
        // System.out.println(instant2);
                                                // 2015–05–25T15:55:00Z

        // using that you can do math
        Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
        System.out.println(nextDay); // 2015–05–26T15:55:00Z
        Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour); // 2015–05–25T16:55:00Z
        // Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); // exception
    }


}