package chpt05.xmpls.datesNTimes;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

class sechste_ocp_schritte {
    public static void main(String[] args) {
        ZonedDateTime gesamtzeitraum = ZonedDateTime.of(2019,4,29,14, 0,0,0,ZoneId.of("Europe/Berlin"));
        // 29/04/2019 2:00
        System.out.println("Zeit: " + gesamtzeitraum.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm")));
        System.out.println("--- Germany ---------------------------------------------");
        // 29.04.2019 14:00 = Short
        System.out.println("Zeit: " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN)));
        // 29.04.2019 14:00 = Long
        System.out.println("Zeit: " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.GERMAN)));
        // 29.04.2019 14:00 = Medium
        System.out.println("Zeit: " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN)));
        // 29.04.2019 14:00 = Full
        System.out.println("Zeit: " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.GERMAN)));

        System.out.println("--- Switzerland -----------------------------------------");
        Locale locCH = new Locale("it", "CH");
        Locale myLocale = Locale.getDefault();
        System.out.println("Mein Standort: " + myLocale);
        System.out.println("Ein weiterer : " + locCH);
        //
        LocalDateTime lokalzeit = LocalDateTime.of(2019,4,29,14, 0, 0, 0);
        System.out.println("Das Datum und die Zeit: " + lokalzeit.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        // ZonedDateTime meineZeitZone = ZonedDateTime.of(lokalzeit, ZoneId.of("US/Pacific");
        Locale locIT = new Locale("it", "IT");
        Locale locPT = new Locale("pt");
        Locale locBR = new Locale("pt", "BR");
        Locale locIN = new Locale("hi", "IN");
        Locale locJA = new Locale("ja");
        Locale locDK = new Locale("dk", "DK");
        //
        System.out.println("----------------------------------------------------------");
        System.out.println("Italy (Long) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.ITALY)));
        System.out.println("Italy (Short) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.ITALY)));
        System.out.println("Japan (Long) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.JAPAN)));
        System.out.println("Portugal (Long) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locPT)));
        System.out.println("India (Long) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locIN)));
        System.out.println("Denmark (Medium) " + gesamtzeitraum.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locDK)));
        //
        System.out.println("----------------------------------------------------------");
        System.out.println("Denmark, country: " + locDK.getDisplayCountry());
        System.out.println("Denmark, country, local: " + locDK.getDisplayCountry(locDK));
        System.out.println("Denmark, country: language" + locDK.getDisplayLanguage());
        System.out.println("Denmark, country: language, locale" + locDK.getDisplayLanguage(locDK));
        //
        System.out.println("----------------------------------------------------------");
        System.out.println("Brazil, country: " + locBR.getDisplayCountry());
        System.out.println("Brazil, country, local: " + locBR.getDisplayCountry(locBR));
        System.out.println("Brazil, country: language" + locBR.getDisplayLanguage());
        System.out.println("Brazil, country: language, locale" + locBR.getDisplayLanguage(locBR));
        //
        System.out.println("----------------------------------------------------------");
        System.out.println("Italy, Danish language is: " + locDK.getDisplayLanguage(locIT));
    }
}
