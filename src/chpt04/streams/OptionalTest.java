/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt04.streams;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author tlubowiecki
 */
public class OptionalTest {
    
    public static void main(String[] args) {
        
        Optional<Integer> o1 = Optional.empty();
        Optional<Integer> o2 = Optional.of(100);
        
        if(o1.isPresent())
            System.out.println(o1.get());
        
        
        o1.ifPresent(System.out::println);
        
        // Wenn Wert vorhanden, dann wert sonst 10
        System.out.println(o1.orElse(10));
        
        System.out.println(o1.orElseThrow(() -> new IllegalArgumentException("Bla bla..")));
        
        System.out.println(o1.orElseGet(() -> { return 10; }));
        
    }
    
    static Optional<Integer> machWas() {
        Random rand = new Random();
        int wert = rand.nextInt(20);
        
        return (wert > 10) ? Optional.of(wert) : Optional.empty();
    }
    
}
