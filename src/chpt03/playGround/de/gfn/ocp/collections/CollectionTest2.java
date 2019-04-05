// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.12 - CollectionTest2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author tlubowiecki
 */
public class CollectionTest2 {
    
    public static void main(String[] args) {
        
        // Hash = Zufallsreihenfolge
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("Peter"));
        persons.add(new Person("Peter"));
        persons.add(new Person("Bruce"));
        persons.add(new Person("Tony"));
        
        List<Person> personsList = new ArrayList<>(persons);
        int i = 0;
        
//        for(Person p : persons) {
//            System.out.println(p.getName());
//            System.out.println(p == personsList.get(i++));
//        }
        
        
        // Baut eine neue Klasse, abgeleitet von Compatrator
        // Die Klasse hat keinen Namen und wird sofort instanziert
        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person arg0, Person arg1) {
//                if(arg0.getName().equals(arg1.getName())) {
//                    return 0;
//                }
//                else {
                    //....
//                }
                return arg0.getName().compareTo(arg1.getName());
            }
        };
        
        Comparator<Person> compCharCount = new Comparator<Person>() {
            @Override
            public int compare(Person arg0, Person arg1) {
//                if(arg0.getName().equals(arg1.getName())) {
//                    return 0;
//                }
//                else {
                    //....
//                }
                return arg1.getName().length() - arg0.getName().length();
            }
        };
        
        // Tree = Sortiert
        Set<Person> newPersons = new TreeSet<>(comp);
        newPersons.addAll(persons);
        newPersons.forEach(e -> System.out.println(e.getName()));
        
        System.out.println("--------");
        
        
        // Linked = Einfügereihenfolge
        Set<String> lSet = new LinkedHashSet<>();
        lSet.add("Peter");
        lSet.add("David");
        lSet.add("Bruce");
        lSet.forEach(e -> System.out.println(e + " " + e.hashCode()));
        
        System.out.println("-----------");
        
        List<Integer> l = Arrays.asList(1,2,5,7,8);
        // l.add(17); // asList liefert eine FixtSize-Liste
        
        System.out.println("-----------");
        
        // Mengenoperationen
        Set<Integer> menge1 = new HashSet<>(Arrays.asList(2,4,6,8,10,12));
        Set<Integer> menge2 = new HashSet<>(Arrays.asList(1,2,6,7,10,11));
        
        // Union
        // menge1.addAll(menge2);
        
        // Minus
        // menge1.removeAll(menge2);
        
        // Intersect
        menge1.retainAll(menge2);
        System.out.println(menge1);
        
        
    }
}

// Durch impl. von Comparable bekommt das Objekt eine natürliche Ordnung
// d.h. ist sortierbar
//class Person implements Comparable<Person>{
class Person {    
    
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj == this)
            return true;
        
        if(obj instanceof Person) {
            return ((Person)obj).name.equals(name);
        }
        
        return false;
    }

//    @Override
//    public int compareTo(Person p) {
//        return name.compareTo(p.name);
//    }
}
