package chpt05.xmpls.datesNTimes;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class meinChrono {

    public static void main(String[] args) {

        LocalDateTime GebDatum = LocalDateTime.of(1982, Month.DECEMBER, 28, 0, 0, 0);
        LocalDateTime Heute = LocalDateTime.of(2019, Month.APRIL, 29, 13, 0, 0);

        System.out.println("*** ---------------------------------------------- ***");
        System.out.println("*** Geboren am                 : " + GebDatum);
        System.out.println("*** Programmiert und gesehen am: " + Heute);

        //
        // Anzahl der vergangenen Tage zwischen der Geburt und Heute
        //
        long years = ChronoUnit.YEARS.between(GebDatum, Heute);
        long months = ChronoUnit.MONTHS.between(GebDatum, Heute);
        long weeks = ChronoUnit.WEEKS.between(GebDatum, Heute);
        long days = ChronoUnit.DAYS.between(GebDatum, Heute);
        long hours = ChronoUnit.HOURS.between(GebDatum, Heute);
        long minutes = ChronoUnit.MINUTES.between(GebDatum, Heute);
        long seconds = ChronoUnit.SECONDS.between(GebDatum, Heute);
        long milis = ChronoUnit.MILLIS.between(GebDatum, Heute);
        long nano = ChronoUnit.NANOS.between(GebDatum, Heute);
        
        System.out.println("*** ---------------------------------------------- ***");
        System.out.println("*** Übersicht der aktuell gelebten Zeit ***");
        System.out.println("*** ---------------------------------------------- ***");
        System.out.println("*** " + years + " Jahre");
        System.out.println("*** " + months + " Monate");
        System.out.println("*** " + weeks + " Wochen");
        System.out.println("*** " + days + " Tage");
        System.out.println("*** " + hours + " Stunden");
        System.out.println("*** " + minutes + " Minuten");
        System.out.println("*** " + seconds + " Sekunden");
        System.out.println("*** " + milis + " Millisekunden");
        System.out.println("*** " + nano + " Nanosekunden");
        System.out.println("*** ---------------------------------------------- ***");
    }
}