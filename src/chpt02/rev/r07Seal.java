// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.7 - review Questions
 *
 *  Listing: - 2.7.17 - r07Seal.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.rev;

import java.util.List;

// make code immutable

public final class r07Seal {        // mark class final
    // String name;
    private final String name;

    private final List<r07Seal> friends;

    // Make a copy of the List<Seal> friends in the constructor. --- how ?
    public r07Seal(String name, List<r07Seal> friends) {
        this.name = name;
        this.friends = friends;
    }

    public String getName() { return name; }

    // Replace the getFriends() method with methods that do not give the caller direct
    // access to the List<Seal> friends. -- How ?
    public List<r07Seal> getFriends() { return friends; }
}