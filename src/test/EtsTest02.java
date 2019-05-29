// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 11 - AllTopicsAtOnce
 *
 *    Thema: - 11.0 - Ets Test 02
 *
 *  Listing: - 11.0.12 - EtsTest02.java
 *  
 *       IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

class Item {
    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class EtsTest02 {
    public static void main(String[] args) {

        List<Item> items = Arrays.asList(
                new Item("Pen"   , "Stationery", 3.0),
                new Item("Pencil", "Stationery", 2.0),
                new Item("Eraser", "Stationery", 1.0),
                new Item("Milk"  , "Food"      , 2.0),
                new Item("Eggs"  , "Food"      , 3.0)
        );

        ToDoubleFunction<Item> priceF = Item::getPrice;

        items.stream()
                .collect(Collectors.groupingBy(Item::getCategory))
                .forEach((a,b) -> {
                    double av = b.stream().collect(Collectors.averagingDouble(priceF));
                    System.out.println(a+" : "+av);
                });
    }
}