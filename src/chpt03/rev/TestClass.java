// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.53 - TestClass.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;

import java.util.*;

public class TestClass {

    public static void main(String[] args) {

        // Q3
        List liste = new ArrayList();
        liste.add("one");
        liste.add("two");
        liste.add(7);
        // for (String s: list)                             // Error here
        //        System.out.print(s);

        System.out.println("\n################################# \n");

        // q4 - output?
        ArrayDeque<String> greetings = new ArrayDeque<String>();
        greetings.push("hello");
        greetings.push("hi");
        greetings.push("ola");
        greetings.pop();
        greetings.peek();
        while (greetings.peek() != null)
            System.out.print(greetings.pop());
                                                             // hihello

        System.out.println("\n################################# \n");

        // 5 - which works ?
        // HashSet<Number> hs = new HashSet<Integer>();
        HashSet<? super ClassCastException> set = new HashSet<Exception>();     // b
        List<String> list = new Vector<String>();                               // c
        // List<Object> values = new HashSet<Object>();
        // List<Object> objects = new ArrayList<? extends Object>();
        Map<String, ? extends Number> hm = new HashMap<String, Integer>();      // f

        System.out.println("\n################################# \n");

        // Q7 - what is true about:
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());                  // output indeterminate
        System.out.println(" -> output indeterminate");

        System.out.println("\n################################# \n");

        // Q8 - Result ?
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println(tree.ceiling("On"));            // One


        System.out.println("\n################################# \n");

        // Q9 - Which fits ?
        Map<String, Double> map = new HashMap<>();
        // map.add("pi", 3.14159);
        // map.add("e", 2L);
        // map.add("log(1)", new Double(0.0));
        // map.add('x', new Double(123.4));
                                                            // none

        System.out.println("\n################################# \n");

        // Q11 - Result ?
        Map<Integer, Integer> map2 = new HashMap<>(10);
        for (int i = 1; i <= 10; i++) {
            map2.put(i, i * i);
        }
        System.out.println(map2.get(4));                     // 16


        System.out.println("\n################################# \n");

        // Q15 - result ?
        Comparator<Integer> c = (o1, o2) -> o2-o1;
        List<Integer> listv = Arrays.asList(5, 4, 7, 1);
        Collections.sort(listv, c);
        System.out.println(Collections.binarySearch(listv, 1));

                                                            // -1

        System.out.println("\n################################# \n");

        // Q19 - what's true
        List<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.print(q);                    // List -> output = [10]
                                                // Queue -> output = [10, 12]

        System.out.println("\n################################# \n");

        // Q20 - result ?
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        // System.out.println(m.contains("123"));          // cannot contains

        System.out.println("\n################################# \n");

        // Q21 - fill in
        List<String> list7 = Arrays.asList("1", "2", "3");
        Iterator iter2 = list7.iterator();
        while(iter2.hasNext())                              // hasNext
            System.out.print(iter2.next());                 // next

        System.out.println(" hasNext  &  next ");

        System.out.println("\n################################# \n");

        // Q24 - which
        Set<String> s = new HashSet<>();
        s.add("lion");
        s.add("tiger");
        s.add("bear");
        // s.forEach(() -> System.out.println(s));
        // s.forEach(s -> System.out.println(s));
        // s.forEach((s) -> System.out.println(s));
        // s.forEach(System.out.println(s));
        // s.forEach(System::out::println);
        s.forEach(System.out::println);                     // only F


        System.out.println("\n################################# \n");

        // Q25 - result ?
        Map<Integer, Integer> map4 = new HashMap<>();
        map4.put(1, 10);
        map4.put(2, 20);
        map4.put(3, null);
        map4.merge(1, 3, (a,b) -> a + b);
        map4.merge(3, 3, (a,b) -> a + b);
        System.out.println(map4);
                                                        // {1=13, 2=20, 3=3}

        System.out.println("\n################################# \n");

    }




}
