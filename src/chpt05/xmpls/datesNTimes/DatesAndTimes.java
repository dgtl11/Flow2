/*******************************
 * Kleine Übersicht
 */
package chpt05.xmpls.datesNTimes;

//
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


class DatesAndTimes {
    
    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*  Chapter 5 - Dates, Strings and Localization  *");
        System.out.println("*  -------------------------------------------  *");
        System.out.println("*   Alle wichtigen Beispiele des Sybex-Buches   *");        
        System.out.println("*               OCP-Exam  1Z0-809               *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*************************************************");
        System.out.println("***");
        //
        //  Es gibt viele Methodensignaturen,
        //  da es auch viele Kombinationen gibt.
        //
        //  Die Methodensignaturen sind wie folgt:
        //  -------------------------------------------------------------
        //  public static LocalDateTime of(int year, int month,
        //      int dayOfMonth, int hour, int minute)
        //  public static LocalDateTime of(int year, int month,
        //      int dayOfMonth, int hour, int minute, int second)
        //  public static LocalDateTime of(int year, int month,
        //      int dayOfMonth, int hour, int minute, int second, int nanos)
        //  public static LocalDateTime of(int year, Month month,
        //      int dayOfMonth, int hour, int minute)
        //  public static LocalDateTime of(int year, Month month,
        //      int dayOfMonth, int hour, int minute, int second)
        //  public static LocalDateTime of(int year, Month month,
        //      int dayOfMonth, int hour, int minute, int second, int nanos)
        //  public static LocalDateTime of(LocalDate date, LocalTime time)        
        //  ------------------------------------------------------------------
        //  public static ZonedDateTime of(int year, int month,
        //      int dayOfMonth, int hour, int minute, int second, int nanos, ZoneId zone)
        //  public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
        //  public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)
        //  ------------------------------------------------------------------
        //  Zeitzone:
        //  >> Greenwich Mean Time << ist eine Zeitzone in Europe welche
        //  als Zeitzone +/- 0 (Zero) als Zeitzone Null wenn über
        //  Offsets in diesem Zusammhang diskutieren wird.
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** LocalDate.now()                           ***");
        System.out.println("*** LocalTime.now()                           ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        // 
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** LocalDateTime.now()                       ***");
        System.out.println("*** ZoneddateTime.now()                       ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        // 
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** LocalDate.of(Jahr, Monat, Tag)            ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);
        //
        System.out.println(date1);
        System.out.println(date2);        
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** LocalTime.of(Stunde, Minute, Sekunde, Nano) *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
        //
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** LocalDateTime.of(Jahr, Monat, Tag, Stunde,  *");
        System.out.println("***      Minute, Sekunde)                       *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
        //
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** ZoneDateTime.of(Jahr, Monat, Tag, Stunde,   *");
        System.out.println("***      Minute, Sekunde, Nano, Zone)           *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20,6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
        //
        System.out.println(zoned1);
        System.out.println(zoned2);
        System.out.println(zoned3);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** boolean Prüfung auf einen Monat             *");
        System.out.println("*** boolean b2 = month == Month.APRIL;          *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        Month month = Month.JANUARY; 
        // Falscher Wert in "b1" für binary operant '=='
        // Erster Wert = boolean und Zweiter Wert = int
        //
        // boolean b1 = month == 1;            // Gibt Fehler aus 
        boolean b2 = month == Month.APRIL;     // Gibt false zurück 
        //
        System.out.println("boolean b2 = month == Month.APRIL;");
        System.out.println("-----------------------------------------");
        System.out.println("Ergebnis = " + b2);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Finden einer Zeitzone                       *");
        System.out.println("*** am Beispiel: Europa und Berlin              *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        ZoneId.getAvailableZoneIds().stream()
        //  auch eine Option durch Verkettung von Bedingungen:
        //
        //  .filter(z -> z.contains("Europe") || z.contains("Berlin"))
        //
            .filter(z -> z.contains("Berlin"))
            .sorted().forEach(System.out::println);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Manipulieren von Datum und Zeit             *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDate date = LocalDate.of(2019, Month.JANUARY, 20);
        System.out.println(date + " = das Ursprungsdatum");
        date = date.plusDays(2);
        System.out.println(date + " = plus 2 Tage");
        date = date.plusWeeks(1);
        System.out.println(date + " = plus 1 Woche");
        date = date.plusMonths(1);
        System.out.println(date + " = plus 1 Monat");
        date = date.plusYears(5);
        System.out.println(date + " = plus 5 Jahre");
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Eine weiter Form des Manipulierens          *");
        System.out.println("*** .minusDays(1).minusHours(10).minusSeconds(30)");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDate date_1= LocalDate.of(2020, Month.JANUARY, 20); 
        LocalTime time_1 = LocalTime.of(5, 15); 
        LocalDateTime dateTime_1 = LocalDateTime.of(date_1, time_1) 
            .minusDays(1).minusHours(10).minusSeconds(30);         
        //
        System.out.println("Vorher:  " + date_1 + "    " + time_1);
        System.out.println("Nachher: " + dateTime_1);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Arbeiten mit Periods                        *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1);             // erstellt eine Periode
        performAnimalEnrichment(start, end, period);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Einweiters Beispiel zu Period             ***");
        System.out.println("*** und der Ausgabeform = P1Y2M3D             ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        System.out.println(Period.of(1,2,3));
        // 
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Arbeitern mit Duration (Dauer)            ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        Duration daily = Duration.ofDays(1);                // PT24H
        System.out.println("Täglich = " + daily);
        Duration hourly = Duration.ofHours(1);              // PT1H
        System.out.println("Stündlich = " + hourly);
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M
        System.out.println("Minütlich = " + hourly);       
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        System.out.println("Seküntlich = " + hourly);       
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S
        System.out.println("Alle Millisekunde = " + hourly);       
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
        System.out.println("Alle Nanosekunde = " + hourly);       
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Arbeiten mit ChronoUnit                     ");
        System.out.println("***  Differenz zwischen                          ");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate datecu = LocalDate.of(2016, 1, 20);
        System.out.println("LocalTime.of(5, 15) und LocalTime.of(6, 30) : " + ChronoUnit.HOURS.between(one, two) + " Stunde(n)");   // 1
        System.out.println("LocalTime.of(5, 15) und LocalTime.of(6, 30) : " + ChronoUnit.MINUTES.between(one, two) + " Minute(n)"); // 75
        //
        // Der folgende Code würde eine DateTimeException ausgeben:
        //
        // System.out.println(ChronoUnit.MINUTES.between(one, datecu)); // DateTimeException 
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Arbeiten mit Instants                       ");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        LocalDate dateIn = LocalDate.of(2015, 5, 25);
        LocalTime timeIn = LocalTime.of(11, 55, 00);
        ZoneId zoneIn = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateIn, timeIn, zoneIn);
        Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
        // 2015–05–25T11:55–04:00[US/Eastern]
        System.out.println("Zeit in der entsprechenden Zeitzone(US/Eastern): " + zonedDateTime);
        // 2015–05–25T15:55:00Z        
        System.out.println("Zeit in der ursprünglichen Lokalen Zeit        : " + instant);
        //
        System.out.println("***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*** Arbeiten mit Instants und ChronoUnit      ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***");
        //
        Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
        System.out.println(nextDay); // 2015–05–26T15:55:00Z
        Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour); // 2015–05–25T16:55:00Z
        //
        // Der folgende Code würde eine Exception ausgeben:
        //
        // Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS);
        //
        System.out.println("***");
        System.out.println("*************************************************");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("***      Kapitel 5  Teil 1 - Abschluss        ***");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*************************************************");
        
    }
    
    private static void performAnimalEnrichment(LocalDate start, LocalDate end,
        Period period) {                            // uses the generic period
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("neuen Zeitraum(period) geben: " + upTo);
            upTo = upTo.plus(period);               // adds the period
        }    
    }
}