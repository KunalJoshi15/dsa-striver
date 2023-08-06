package collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuesInJava {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Test");
        queue.add("NASND");
        System.out.print(queue);
        queue.remove();
        System.out.print(queue);
        queue.remove();
        System.out.print(queue);

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("Test");
        arrayDeque.add("test2");
        arrayDeque.add("test3");

        System.out.print(arrayDeque);
        arrayDeque.removeFirst();
        System.out.print(arrayDeque);
        arrayDeque.removeLast();
        System.out.print(arrayDeque);

    }
}
