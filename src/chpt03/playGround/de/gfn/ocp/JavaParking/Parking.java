// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.x - AnwendungsBeispiel
 *
 *  Listing: - 3.x.10 - Parking.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.JavaParking;

import java.util.*;

public class Parking {

    private final int SIZE;
    private final List<Car> cars;

    public Parking(int size) {
        this.SIZE = size;
        cars = new ArrayList<>(size);
    }

    public Car remove(String registration) {

        int pos = findCar(registration);
        if(pos >= 0) {
            Car c = cars.remove(pos);
            c.setEnd();
            return c;
        }


        return null;
    }

    private int findCar(String registration) {
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getRegistration().equalsIgnoreCase(registration))
                return i;
        }
        return -1; // if not found irrationall number of parking spaces
    }

    public boolean insert(Car car) {
        if(cars.size() >= SIZE)
            return false;

        return cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}

