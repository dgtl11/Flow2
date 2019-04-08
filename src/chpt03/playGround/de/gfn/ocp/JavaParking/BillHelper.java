// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.x - AnwendungsBeispiel
 *
 *  Listing: - 3.x.13 - BillHelper.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.JavaParking;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public final class BillHelper  {

    private static final double defaultPricePerMinute = 0.10;

    private BillHelper() {
    }

    public static void showBill(Car car) {
        showBill(car, defaultPricePerMinute);
    }

    public static void showBill(Car car, double pricePerMinute) {
        // Instant start = car.getStart().toInstant(ZoneOffset.UTC);
        // Instant end = car.getStart().toInstant(ZoneOffset.UTC);
        // int minutes = (int)Duration.between(start, end).get(ChronoUnit.MINUTES);
        int minutes = getParkingTimeInMinutes(car);

        System.out.printf("Minuten: %d \n", minutes);
        System.out.printf("Preis: %.2f € \n", minutes * pricePerMinute );
    }

    public static int getParkingTimeInMinutes (Car car) {
        Instant start = car.getStart().toInstant(ZoneOffset.UTC);
        Instant end = car.getStart().toInstant(ZoneOffset.UTC);
        return (int) Duration.between(start, end).toMinutes();
    }

}
