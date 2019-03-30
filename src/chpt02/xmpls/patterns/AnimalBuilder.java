// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.3 - builder pattern
 *
 *  Listing: - 2.5.11 - AnimalBuilder.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

import java.util.*;

public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal2 build() {
        return new Animal2(species, age, favoriteFoods);
    }
}

// also valid
/*
    AnimalBuilder duckBuilder = new AnimalBuilder();
    duckBuilder
        .setAge(4)
        .setFavoriteFoods(Arrays.asList("grass","fish")).setSpecies("duck");
    Animal duck = duckBuilder.build();

    Animal flamingo = new AnimalBuilder()
        .setFavoriteFoods(Arrays.asList("algae","insects"))
        .setSpecies("flamingo").build();

*/