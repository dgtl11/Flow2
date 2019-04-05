// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.0 - Introduction
 *
 *  Listing: - 3.0.00 - TetstClass.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;

import java.util.*;

class Request {
}

class RequestCollector {
    //1 : Insert declaration here
    Queue<Request> container = new LinkedList<Request>();

    // LinkedList container = new LinkedList();
    // Queue container = new PriorityQueue();
    // List al = new ArrayList();


    public synchronized void addRequest(Request r) {
        container.add(r);
    }

    public synchronized Request getRequestToProcess() {
        return container.poll();
    }
}