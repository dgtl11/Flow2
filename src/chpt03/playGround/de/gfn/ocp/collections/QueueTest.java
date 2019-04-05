// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.13 - QueueTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.collections;

import java.util.*;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> q1 = new LinkedList<>();

        q1.add("Hamburg");
        q1.offer("München");

        System.out.println(q1.element());
        System.out.println(q1.peek());

        System.out.println("--------------");

        System.out.println(q1.remove());
        System.out.println(q1.poll());

        System.out.println("--------------");


        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        // wird erst sortiert
        q2.addAll(Arrays.asList(7,15,22,1,9,12));

        System.out.println(q2);              // [1,7,12,15,9,22] Anzeige stimmt nicht unbedingt mit realität überein
        System.out.println(q2.remove());     // kleinstes = 1

        // change order
        // PriorityQueue<Integer> q3 = new PriorityQueue<>((a,b) -> a.hashCode() - b.hashCode());
        // PriorityQueue<Integer> q4 = new PriorityQueue<>((a,b) -> b.hashCode() - a.hashCode());

        System.out.println(q2.remove());
        System.out.println(q2.remove());
        System.out.println(q2.remove());
        System.out.println(q2.remove());
        System.out.println(q2.remove());
        System.out.println(q2.poll());      // threat safe -> slower , old
        System.out.println(q2.poll());      // threat safe -> slower , old

        System.out.println("--------------");

        Deque<String> dq1 = new LinkedList<>();
        dq1.push("Hamburg");
        dq1.push("Berlin");
        dq1.push("München");
        System.out.println(dq1.pop());

        System.out.println("--------------");

        List<Integer> l1 = new ArrayList<>(Arrays.asList(2,5,7,9,22));
        ListIterator<Integer> litr = l1.listIterator();


        while(litr.hasNext()) {
            System.out.println(litr.next());
        }
        while(litr.hasPrevious()) {
            System.out.println(litr.previous());
        }

        NavigableSet<Integer> s5 = new TreeSet<>(Arrays.asList(2,3,7,9,22));
        Iterator<Integer> itr = s5.descendingIterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("--------------");

        Set<Test> s6 = new TreeSet<>((a,b) -> a.hashCode() - b.hashCode());
        // Test muss Comparable sein oder TreeSet muss
        // bei der Instanzierung einen Comparator bekommen
        s6.add(new Test());

        System.out.println("--------------");

        // revQ 7 ???
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());

        System.out.println("--------------");

        // revQ8
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println(tree.ceiling("On"));
    }

}

class Test {

}