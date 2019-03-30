// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.2 - Creating immutable classes
 *
 *  Listing: - 2.5.10 - Animal2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

import java.util.ArrayList;
import java.util.List;

public final class Animal2 {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal2(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }
}

// u cannot modify a immutable object
// but copy and change like with strings
/*
    String firstName = "Grace";
    String fullName = firstName + " Hopper";


// Create a new Animal instance
    Animal lion = new Animal("lion", 5, Arrays.asList("meat","more meat"));

// Create a new Animal instance using data from the first instance
    List<String> favoriteFoods = new ArrayList<String>();
    for(int i=0; i<lion.getFavoriteFoodsCount(); i++) {
        favoriteFoods.add(lion.getFavoriteFood(i));
    }

    Animal updatedLion = new Animal(lion.getSpecies(), lion.getAge()+1, favoriteFoods);

*/