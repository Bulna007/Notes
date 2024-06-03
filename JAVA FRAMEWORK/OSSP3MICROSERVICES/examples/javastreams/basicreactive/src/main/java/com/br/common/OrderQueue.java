package com.br.common;

import java.util.ArrayDeque;
import java.util.Queue;

public class OrderQueue {
    private static OrderQueue instance;
    private Queue<String> orderQueue;

    private OrderQueue() {
        orderQueue = new ArrayDeque<>();
    }

    public static synchronized OrderQueue getInstance() {
        if (instance == null) {
            instance = new OrderQueue();
        }
        return instance;
    }

    public void add(String item) {
        orderQueue.add(item);
    }

    public String enqueue() {
        return orderQueue.remove();
    }

    public boolean hasItems() {
        return !orderQueue.isEmpty();
    }
}
