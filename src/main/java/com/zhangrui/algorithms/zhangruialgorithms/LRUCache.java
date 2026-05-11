package com.zhangrui.algorithms.zhangruialgorithms;

import java.util.HashMap;

public class LRUCache {

    /**
     * key -> Node
     */
    private final HashMap<Integer, Node> map;

    /**
     * 双向链表
     */
    private final DoubleList cache;

    /**
     * 容量
     */
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    /**
     * 节点
     */
    public static class Node {

        int k;
        int v;

        Node prev;
        Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    /**
     * 双向链表
     *
     * head -> 最近最久未使用
     * tail -> 最近使用
     */
    public static class DoubleList {

        /**
         * 虚拟头节点
         */
        private final Node head;

        /**
         * 虚拟尾节点
         */
        private final Node tail;

        /**
         * 链表大小
         */
        private int size;

        public DoubleList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        /**
         * 添加到队尾（最近使用）
         */
        public void addLast(Node x) {

            x.prev = tail.prev;
            x.next = tail;

            tail.prev.next = x;
            tail.prev = x;

            size++;
        }

        /**
         * 删除指定节点
         */
        public void remove(Node x) {

            x.prev.next = x.next;
            x.next.prev = x.prev;

            // 断开引用
            x.prev = null;
            x.next = null;

            size--;
        }

        /**
         * 删除最久未使用节点
         */
        public Node removeFirst() {

            // 空链表
            if (head.next == tail) {
                return null;
            }

            Node first = head.next;

            remove(first);

            return first;
        }

        public int size() {
            return size;
        }
    }

    /**
     * 获取元素
     */
    public int get(int key) {

        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        // 移动到最近使用
        makeRecently(node);

        return node.v;
    }

    /**
     * 插入元素
     */
    public void put(int key, int value) {

        Node node = map.get(key);

        /**
         * key 已存在
         */
        if (node != null) {

            // 更新 value
            node.v = value;

            // 移动到最近使用
            makeRecently(node);

            return;
        }

        /**
         * 容量满了
         */
        if (cache.size() == capacity) {

            // 淘汰最久未使用
            Node deletedNode = cache.removeFirst();

            if (deletedNode != null) {
                map.remove(deletedNode.k);
            }
        }

        /**
         * 新节点
         */
        Node newNode = new Node(key, value);

        // 放到最近使用
        cache.addLast(newNode);

        map.put(key, newNode);
    }

    /**
     * 将节点变成最近使用
     */
    private void makeRecently(Node node) {

        cache.remove(node);

        cache.addLast(node);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}