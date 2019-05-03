package chpt05.rev;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.ResourceBundle;


public class DateTimeFormater {
    public static void main(String[] args) {
        //
        // Aufgabe 1
        //
        System.out.println();
        System.out.println("Aufgabe 1");
        System.out.println();
        // ZonedDateTime zd = ZonedDateTime.parse("2020-05-04T08:05:00");
        // System.out.println(zd.getMonth() + " " + zd.getDayOfMonth());
        System.out.println("\nDie richtige Antwort ist > F < = RuntimeError");
        //
        // Aufgabe 2
        //
        System.out.println();
        System.out.println("Aufgabe 2");
        System.out.println();
        LocalTime t1 = LocalTime.of(9,0);
        System.out.println("Richtig t1 " + t1); 
        LocalTime t2 = LocalTime.of(10, 5);
        System.out.println("Richtig t2 " + t2); 
        LocalTime t3_A = t1.plus(65, ChronoUnit.MINUTES);
        System.out.println("t3_A " + t3_A); 
        LocalTime t3_B = t1.plusMinutes(65);
        System.out.println("t3_B " + t3_B); 
        LocalTime t3_C = t1.plusHours(1);
        System.out.println("t3_C " + t3_C); 
        // LocalTime t3_D = t1.plusDays(1);
        System.out.println("t3_D (plusDays() erwartet einen int, aber t1 ist ein LocalTime)");
        LocalTime t3_E = t1.plus(Duration.ofMinutes(65));
        System.out.println("Richtig t3_E " + t3_E);
        //
        // Aufgabe 3
        //
        System.out.println();
        System.out.println("Aufgabe 3");
        System.out.println();
        LocalDate d1 = LocalDate.of(2018,1,1);
        LocalDate d2 = LocalDate.of(2018,6,15);
        Period r = Period.between(d1, d2);
        System.out.println("3_E) Months an days: " + r.getMonths() + ", " + r.getDays());
        //
        // Aufgabe 4
        //
        System.out.println();
        System.out.println("Aufgabe 4");
        System.out.println();
        ZonedDateTime nowzdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Pacific"));
        //
        System.out.println("Der Inhalt von nowzdt ist: " + nowzdt);
        System.out.println();
        //
        // ZonedDateTime berlinZdtA = ZonedDateTime.from(nowzdt, ZoneId.of("Europe/Berlin"));
        System.out.println("berlinZdtA - Rote Meldung: Split into declaration and assignment ");
        ZonedDateTime berlinZdtB = nowzdt.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        System.out.println("berlinZdtB = " + berlinZdtB);
        ZonedDateTime berlinZdtC = ZonedDateTime.ofInstant(nowzdt.toInstant(), ZoneId.of("Europe/Berlin"));
        System.out.println("berlinZdtC = " + berlinZdtC);
        // ZonedDateTime berlinZdtD = nowzdt.withZoneId("Europe/Berlin");
        System.out.println("berlinZdtD - Der Inhalt von nowzdt enthaelt keine Methode: withZoneId");
        ZonedDateTime berlinZdtE = nowzdt.now(ZoneId.of("Europe/Berlin"));
        System.out.println("berlinZdtE = " + berlinZdtE);
        //
        //
        // Aufgabe 5
        //
        System.out.println();
        System.out.println("Aufgabe 5");
        System.out.println();
        // A
        // ZonedDateTime totalityUTCA = ZonedDateTime.of(
        //        LocalDateTime.of(2019,7,2,16,55));
        // ZonedDateTime totalitySanJuanA = 
        //        totalityUTCA.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        System.out.println("5-A) Fehler"); //  + totalitySanJuanA
        // B
        // ZonedDateTime totalityUTCB = ZonedDateTime.of(
        //         LocalDateTime.of(2019,7,2,4,55, "PM"));
        // ZonedDateTime totalitySanJuanB = 
        //         totalityUTCB.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        System.out.println("5-B) Fehler"); //  + totalitySanJuanB
        // C
        ZonedDateTime totalityUTCC = ZonedDateTime.of(
                LocalDateTime.of(2019,7,2,16,55), ZoneId.of("Z"));
        ZonedDateTime totalitySanJuanC = 
                totalityUTCC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        System.out.println("C) " + totalitySanJuanC);
        // D
        ZonedDateTime totalityUTCD = ZonedDateTime.of(
                LocalDateTime.of(2019,7,2,16,55), ZoneId.of("America/Argentina/San_Juan"));
        ZonedDateTime totalitySanJuanD = 
                totalityUTCD.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        System.out.println("D) " + totalitySanJuanD);
        // E
        // ZonedDateTime totalityUTCE = ZonedDateTime.of(
        //        LocalDateTime.of(2019,7,2,16,55), ZoneId.of("Z"));
        // LocalTime totalitySanJuanE = 
        //         totalityUTCE.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
        // System.out.println("5-B) Fehler"); //  + totalitySanJuanE
        //
        //
        // Aufgabe 6
        //
        System.out.println();
        System.out.println("Aufgabe 6");
        System.out.println();
        // ResourceBundle rb = ResourceBundle.getBundle("Flag", new Locale("en", "CA"));
        System.out.println("Aufgabe 6 (A,C,D,E) : ");  // + rb.getString("key"))
        //
        // Aufgabe 7
        //
        System.out.println();
        System.out.println("Aufgabe 7");
        System.out.println();
        //
        System.out.println("Lösung ist D - Zeile 5 US durch UK ersetzen");
        //
        // Aufgabe 8
        //
        System.out.println();
        System.out.println("Aufgabe 8");
        System.out.println();
        // public class DateHalloween {
        ZonedDateTime d = ZonedDateTime.of(2018,10,31,17,0,0,0, ZoneId.of("Europe/Berlin"));
        Locale locDE = new Locale("de");
        DayOfWeek day = d.getDayOfWeek();
        String df = d.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locDE));
        System.out.println(day + " " + df);
        //
        // Aufgabe 9
        //
        System.out.println();
        System.out.println("Aufgabe 9 - Löungen C + E");
        System.out.println();
        //
        // Aufgabe 10
        //
        System.out.println();
        System.out.println("Aufgabe 10");
        System.out.println();
        LocalDateTime now = LocalDateTime.of(2017,10,27,14,22,54,0);
        //
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String formattedDateTimeA = now.format(formatterA);
        System.out.println("a) Formatted dateTime: " + formattedDateTimeA);
        //
        DateTimeFormatter formatterB = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String formattedDateTimeB = now.format(formatterB);
        System.out.println("b) Formatted dateTime: " + formattedDateTimeB);
        //
        DateTimeFormatter formatterC = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:MM:ss");
        String formattedDateTimeC = now.format(formatterC);
        System.out.println("c) Formatted dateTime: " + formattedDateTimeC);
        //
        DateTimeFormatter formatterD = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTimeD = now.format(formatterD);
        System.out.println("d) Formatted dateTime: " + formattedDateTimeD);
        //
        // Exception
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        // DateTimeFormatter formatterE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        // String formattedDateTimeE = now.format(formatterE);
        System.out.println("e) Formatted dateTime: wirft Exception: java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds" );
        //
        // Aufgabe 11
        //
        System.out.println();
        System.out.println("Aufgabe 11");
        System.out.println();
        LocalDate d_1 = LocalDate.of(2017, Month.NOVEMBER, 28);
        System.out.print("c) " + d_1 + ", ");
        LocalDate d_2 = d1.with(TemporalAdjusters.lastDayOfYear());
        System.out.print(d_2 + ", ");
        LocalDate d_3 = d1.plusDays(3).with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.print(d_3 + ", ");
        LocalDate d_4 = d1.minusMonths(11).with(TemporalAdjusters.firstDayOfNextYear());
        System.out.print(d_4 + ", ");
        LocalDate d_5 = LocalDate.ofEpochDay(d1.plusDays(27).toEpochDay());
        System.out.print(d_5 + ", ");
        LocalDate d_6 = d1.minus(Period.ofDays(5));
        System.out.println(d_6);
        //
        // Aufgabe 12
        //
        System.out.println();
        System.out.println("Aufgabe 12");
        System.out.println();
        ZoneId zid = ZoneId.of("US/Eastern");  // GMT-5:00
        Instant i = Instant.now();
        ZonedDateTime zdt = i.atZone(zid);
        System.out.println(zdt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        //
        // Das waren die Aufgaben aus dem kleinen Test zu Kapitel 5
        //
    }
}