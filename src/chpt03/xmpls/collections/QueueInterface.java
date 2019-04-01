// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.3 - Using Lists, Sets, Maps, and Queues
 *             2.3.4 - Using the Queue Interface
 *
 *  Listing: - 2.3.19 - QueueInterface.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueInterface {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null


        // stack functionality:
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek()); // 4
        System.out.println(stack.poll()); // 4
        System.out.println(stack.poll()); // 10
        System.out.println(stack.peek()); // null

    }

}

