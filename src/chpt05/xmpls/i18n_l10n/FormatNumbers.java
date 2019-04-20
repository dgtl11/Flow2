// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.12 - FormatNumbers.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatNumbers {

    public static void main(String[] args) throws ParseException {

        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth));
        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(g.format(attendeesPerMonth));
        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth));

//        System.out.println("###############################");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // working with currency
        double price = 48;
        NumberFormat us2 = NumberFormat.getCurrencyInstance();
        System.out.println(us2.format(price));

//         System.out.println("###############################");

        // parsing
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";
        System.out.println(en.parse(s)); // 40.45
        System.out.println(fr.parse(s)); // 40

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        NumberFormat nf = NumberFormat.getInstance();
        String one = "456abc";
        String two = "-2.5165x10";
        String three = "x85.3";
        System.out.println(nf.parse(one)); // 456
        System.out.println(nf.parse(two)); // -2.5165
        // System.out.println(nf.parse(three));// throws ParseException

        String amt = "$92,807.99";
        NumberFormat cf = NumberFormat.getCurrencyInstance();
//        double value = (Double) cf.parse(amt);
//        System.out.println(value); // 92807.99

        System.out.println("###############################");

        // formating dates & times
        LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 20);
        System.out.println(date1.getDayOfWeek());// MONDAY
        System.out.println(date1.getMonth());// JANUARY
        System.out.println(date1.getYear());// 2020
        System.out.println(date1.getDayOfYear());// 20

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // dateTimeFormater
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // short
        DateTimeFormatter shortDateTime1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortDateTime1.format(dateTime));// 1/20/20
        System.out.println(shortDateTime1.format(date));// 1/20/20
//        System.out.println(shortDateTime1.format(time));      // UnsupportedTemporalTypeException

        DateTimeFormatter shortDateTime2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dateTime.format(shortDateTime2));
        System.out.println(date.format(shortDateTime2));
//        System.out.println(time.format(shortDateTime2));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // medium
        LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time3 = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime3 = LocalDateTime.of(date3, time3);
        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime3));// 1/20/20 11:12 AM
        System.out.println(mediumF.format(dateTime3));// Jan 20, 2020 11:12:34 AM

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // customized patterns
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

        // MMMM - month
        // dd   - days
        // ,
        // yyyy - year
        // hh   - hour
        // :
        // mm   - minutes

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // rev: what xcptns ?
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:mm");
        f2.format(dateTime);
//         f2.format(date);         // date has no time
        f2.format(time);

        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date4 = LocalDate.parse("01 02 2015", f3);
        LocalTime time4 = LocalTime.parse("11:22");
        System.out.println(date4);// 2015–01–02
        System.out.println(time4);// 11:22

    }



}

