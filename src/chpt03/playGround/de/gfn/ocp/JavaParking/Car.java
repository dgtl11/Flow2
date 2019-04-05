// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.x - AnwendungsBeispiel
 *
 *  Listing: - 3.x.11 - Car.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.JavaParking;

import java.time.LocalDateTime;

public class Car {

    private final String registration;

    private final LocalDateTime start;
    private LocalDateTime end;

    public Car(String registration) {
        this.registration = registration;
        start = LocalDateTime.now();
    }

    public String getRegistration() {
        return registration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd() {
        this.end = LocalDateTime.now();
    }

}
