package com.zhangrui.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/11 12:37
 */
public class LRUCacheX {

    private int capacity;

    private Map<Integer, Integer> map = new HashMap<>();

    private DoubleList cache = new DoubleList();

    public static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class DoubleList {
        Node head;
        Node tail;
        int size;
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }
    }

    public LRUCacheX(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.cache = new DoubleList();
    }

    public int get(int key) {
        // TODO:  
        return -1;
    }
    
    public void put(int key, int value) {
        // TODO:  
    }
    
    public void delete(Node node) {
        // TODO:
    }


}
