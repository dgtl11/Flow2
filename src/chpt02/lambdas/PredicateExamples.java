package chpt02.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
 
public class PredicateExamples {
 
    private static void print(List<String> users, Predicate<String> empPredicate) {
        System.out.println("!! 'Predicate List' Output !!");
        for(String name : users) {
            if(empPredicate.test(name))
                System.out.println(name);
        }
 
        System.out.println("\n");
    }
 
    public static void main(String[] args) {
 
        /***** Example #1 - Predicate String *****/
        Predicate<String> predicateString = s -> {
            return s.equals("Java Code Geek");
        };
 
        System.out.println("!! 'Predicate String' Output !!");
        System.out.println(predicateString.test("Java Code Geek"));
        System.out.println(predicateString.test("Java Geek") + "\n");
 
        /***** Example #2 - Predicate Integer *****/
        Predicate<Integer> predicateInt = i -> {
            return i > 0;
        };
 
        System.out.println("!! 'Predicate Integer' Output !!");
        System.out.println(predicateInt.test(10));
        System.out.println(predicateInt.test(-10) + "\n");
 
        /***** Example #3 - Predicate List *****/
        List<String> users = new ArrayList<String>();       
        users.add("Bob");
        users.add("Jane");
        users.add("Jordi");
        print(users, user -> user.startsWith("J"));
 
        /***** Example #4 - Predicate Default Methods *****/
        Predicate<String> predicate = s-> {
            return s.equals("Java");
        };
 
        /** (4a) - AND Logical Operation **/ 
        Predicate<String> predicateAnd = predicate.and(s -> s.length() > 3);
        System.out.println("!! 'Predicate Logical And' Output !!");
        System.out.println(predicateAnd.test("Java") + "\n");
 
        /** (4b) - OR Logical Operation **/
        Predicate<String> predicateOr = predicate.or(s -> s.length() == 10);
        System.out.println("!! 'Predicate Logical Or' Output !!");
        System.out.println(predicateOr.test("Java") + "\n");
 
        /** (4c) - NEGATE Logical Operation **/
        Predicate<String> predicateNegate = predicate.negate();
        System.out.println("!! 'Predicate Logical Negate' Output !!");
        System.out.println(predicateNegate.test("Java") + "\n");
    }
}