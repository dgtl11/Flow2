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

import java.io.Serializable;
import java.util.*;

public class Parking implements Serializable {

    private final int SIZE;
    // private final List<Car> cars;
    private final Map<String, Car> cars;

    public Parking(int size) {
        this.SIZE = size;
        // TODO:
        cars = new HashMap<>(size);  // TreeMap falls sortiert notwendig
    }

    public Car remove(String registration) {

/*
        int pos = findCar(registration);
        if(pos >= 0) {
            Car c = cars.remove(pos);
            c.setEnd();
            return c;
        }
*/
        Car car = cars.remove(registration);
        if(car != null)
            car.setEnd();

        return car;
    }

/*
    private int findCar(String registration) {
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getRegistration().equalsIgnoreCase(registration))
                return i;
        }
        return -1; // if not found irrationall number of parking spaces
    }
*/

    public boolean insert(Car car) {
        if(cars.size() >= SIZE)
            return false;

        if(cars.containsKey(car.getRegistration()))
            return false;

        cars.put(car.getRegistration(), car);
        return true;
        // return cars.add(car);
    }

    public Collection<Car> getCars() {
        return cars.values();
    }
}
