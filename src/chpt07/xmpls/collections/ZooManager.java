// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.4 - Using Concurrent Collections
 *
 *  Listing: - 07.4.17 - ZooManager.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.xmpls.collections;


import java.util.*;
import java.util.concurrent.*;

public class ZooManager {

    // synchronized classic Map
    /*   private Map<String,Object> foodData = new HashMap<String,Object>();
        public synchronized void put(String key, String value) {
            foodData.put(key, value);
        }
        public synchronized Object get(String key) {
            return foodData.get(key);
        }
    */

    // Concurrent Collection
    private Map<String,Object> foodData = new ConcurrentHashMap<String,Object>();
    public void put(String key, String value) {
        foodData.put(key, value);
    }
    public Object get(String key) {
        return foodData.get(key);
    }

    public static void main(String[] args) {

        // ConcurrentModificationException
        /*
        Map<String, Object> foodData2 = new HashMap<String, Object>();
        foodData2.put("penguin", 1);
        foodData2.put("flamingo", 2);
        for(String key: foodData2.keySet())
            foodData2.remove(key);

         */

        Map<String, Object> foodData = new ConcurrentHashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for(String key: foodData.keySet())
            foodData.remove(key);

        // xmpls:
        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());

        // blockingQueue
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }

        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }

        // CopyOnWrite Collections
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for(Integer item: list) {
            System.out.print(item+" ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: "+list.size());


        // synchronized collections
        List<Integer> list2 = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList(4,3,52)));
        synchronized(list2) {
            for(int data: list2)
                System.out.print(data+" ");
        }


        // ConcurrentModificationException
        /*
        Map<String, Object> foodData2 = new HashMap<String, Object>();
        foodData2.put("penguin", 1);
        foodData2.put("flamingo", 2);
        Map<String,Object> synchronizedFoodData = Collections.synchronizedMap(foodData2);
        for(String key: synchronizedFoodData.keySet())
            synchronizedFoodData.remove(key);
        */
    }
}
