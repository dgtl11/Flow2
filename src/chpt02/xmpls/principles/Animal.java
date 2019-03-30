// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.4 - Understanding Design Principles
 *             2.4.1 - Encapsulation
 *
 *  Listing: - 2.4.01 - Animal.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.principles;

/* could be going horribly wrong :

public class Animal {
    public String species;
    public int age;
}

    Animal animal = new Animal();
animal.age = -100;

so Encapsulation to the Rescue:
*/

public class Animal {
    private String species;
    private int age;

    public Animal(String species) {
        this.setSpecies(species);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if(species == null || species.trim().length()==0) {
            throw new IllegalArgumentException("Species is required");
        }
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0) {
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
        this.age = age;
    }
}

/* Even a prototype is worlds better couse it could be extended later :

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    extended like:

    public void setName(String name) {
        this.name = (name == null || name.trim().length()==0) ? null: name;
    }

 */