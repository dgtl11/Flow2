// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Streams
 *
 *    Thema: - 4.x - AnwendungsBeispiel
 *
 *  Listing: - 4.x.11 - ReductionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.streams;

import java.util.*;
import java.util.stream.Stream;
import java.lang.StringBuilder;
import java.util.stream.Collectors;

/**
 *
 * @author tlubowiecki
 */
public class ReductionTest {

    public static void main(String[] args) {

        Stream<String> str = Stream.of("H", "A", "L", "L", "O", "!!", "ae", "123", "abc");

        // Immutable Reduction
        // System.out.println(str.reduce("", (a, b) -> a + b));



        // Mutable Reduction
        //StringBuilder erg = str.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        //TreeSet<String> erg = str.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        //ArrayList<String> erg = str.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        //List<String> erg = str.collect(Collectors.toList());
        //Set<String> erg = str.collect(Collectors.toSet());
        // Collection<String> erg = str.collect(Collectors.toCollection(HashSet::new));

        // String erg = str.collect(Collectors.joining());
        // String erg = str.collect(Collectors.joining("-"));
        // String erg = str.collect(Collectors.joining("-", "#", "#"));


        //        Map
        //          1 List h, a, l, l, o
        //          2 List !!

        //Map<Integer, List<String>> erg = str.collect(Collectors.groupingBy(String::length));

        Map<Boolean, List<String>> erg = str.collect(Collectors.partitioningBy(s -> s.length() == 1));
        System.out.println(erg.get(true));

        System.out.println("##################  heldenListe ######################################");

        List<Benutzer> benutzer = new ArrayList<>();
        benutzer.add(new Benutzer("Peter", "Parker", "New York"));
        benutzer.add(new Benutzer("Clark", "Kent", "Metropolis"));
        benutzer.add(new Benutzer("Bruce", "Wayne", "Boston"));
        benutzer.add(new Benutzer("Bruce", "Banner", "Boston"));
        benutzer.add(new Benutzer("Tony", "Stark", "Miami"));
        benutzer.add(new Benutzer("Max", "Musterman", "New York"));

        System.out.println("##################  who lives where ##################################");

        Map<String, List<Benutzer>> helden = benutzer.stream().collect(Collectors.groupingBy(Benutzer::getWohnort));

        System.out.println(helden);

        System.out.println("##################  who lives in New York ############################");

        System.out.println(helden.get("New York"));

        System.out.println("##################  other cities ######################################");

        Stream<String> strStream = Stream.of("Hamburg", "Berlin", "München", "Hagen");

        Map<String, Integer> map = strStream.collect(Collectors.toMap(String::toUpperCase, String::length));
        System.out.println(map);

        System.out.println("##################  ordered cities ####################################");

        Comparator<Benutzer> comp = (a, b) -> a.getWohnort().compareTo(b.getWohnort());

        System.out.println(benutzer.stream().sorted(comp).findAny());
        // ohne comparator -->> xcptn

        System.out.println("##################  ordered cities ####################################");

        System.out.println(benutzer.stream().min(comp));
        System.out.println(benutzer.stream().max(comp));

    }

}

class Benutzer {
  private final String vorname;
  private final String nachname;
  private final String wohnort;

  public Benutzer(String vorname, String nachname, String wohnort) {
      this.vorname = vorname;
      this.nachname = nachname;
      this.wohnort = wohnort;
  }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getWohnort() {
        return wohnort;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Vorname : ").append(vorname)
              .append(", Nachname : ").append(nachname)
              .append(", wohnt in : ").append(wohnort);
      return sb.toString();
    }
}

