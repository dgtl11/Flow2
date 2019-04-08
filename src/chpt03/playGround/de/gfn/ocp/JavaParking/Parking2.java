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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tlubowiecki
 */
public class Parking2 implements Serializable {

    private final int SIZE;
    //private final List<Car> cars;
    private final Map<String, Car> cars;

    public Parking2(int size) {
        SIZE = size;
        // TODO: Sortierung
        cars = new HashMap<>(size);
    }

    public Car remove(String registration) {
//        int pos = findCar(registration);
//        if(pos >= 0) {
//            Car c = cars.remove(pos);
//            c.setEnd();
//            return c;
//        }

        Car car = cars.remove(registration);
        if(car != null)
            car.setEnd();

        return car;
    }

//    private int findCar(String registration) {
//        for(int i = 0; i < cars.size(); i++) {
//            if(cars.get(i).getRegistration().equalsIgnoreCase(registration))
//                return i;
//        }
//        return -1;
//    }

    public boolean insert(Car car) {

        if(cars.size() >= SIZE)
            return false;

        if(cars.containsKey(car.getRegistration()))
            return false;

        cars.put(car.getRegistration(), car);
        return true;
    }

    public Collection<Car> getCars() {
        return cars.values();
    }
}




