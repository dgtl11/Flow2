package chpt05.xmpls.datesNTimes;

import java.time.*;

// Local Dates and Times
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
// Zoned Dates and Times
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
// Formaters for Dates and Times
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.time.format.TextStyle;
// Adjustmenets to Date an Times
import java.time.temporal.ChronoUnit;
import java.time.temporal.*;
// Periods, Durantions and Instants
import java.time.Period;
import java.time.Duration;
import java.time.Instant;

//
// In Java 8 sind insgesamt 22 Methoden oder Konstruktoren von Date als "deprecated = veraltet" markiert
//
class dritte_ocp_schritte {
    public static void main(String[] args) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        //
        LocalDate eclipseDate1 = LocalDate.of(2019,4,29);
        LocalDate eclipseDate2 = LocalDate.parse("2019-04-29");
        System.out.println("Sonnenuntergang in Heidelberg (Eclipse)");
        System.out.println("Eclipse date: " + eclipseDate1 + ", " + eclipseDate2);
        
        LocalTime begins = LocalTime.of(20,39,00);
        LocalTime gesamt = LocalTime.parse("20:39:00");
        
        System.out.println("Eclipse startet um " + begins + " und Endet um " + gesamt);
        
        String eclipsdateTime = "2019-04-29 20:39";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime eclipseDay = LocalDateTime.parse(eclipsdateTime, formatter);
        System.out.println("Eclipse day: " + eclipseDay);

        System.out.println("Aktuelle Zeit " + eclipseDay.plusWeeks(1));
        System.out.println("Aktuelle Zeit " + eclipseDay.minusHours(2));
        
        ZonedDateTime zEineDateTimeZone = ZonedDateTime.of(eclipseDay, ZoneId.of("US/Pacific"));
        System.out.println("eclipseDay " + zEineDateTimeZone);
        System.out.println("Eclipse day: " + eclipseDay);
    }
}
