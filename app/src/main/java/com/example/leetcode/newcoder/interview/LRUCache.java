package com.example.leetcode.newcoder.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>{
    int capacity;
    private Map<K, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node != null){
            moveNodeToTail(node);
            return map.get(key).val;
        }
        return null;
    }

    private void moveNodeToTail(Node node) {
        if (tail == node)
            return;
        if (head == node){
            head = head.next;
            head.pre = null;
        }
        node.next = null;
        node.pre = tail;
        tail.next = node;
        tail = node;
    }

    public void put(K key, V value) {
        Node node = map.get(key);
        if (node != null){
            node.val = value;
            moveNodeToTail(node);
        }else {
            Node addnode = new Node(key, value);
            if (capacity <= map.size()){
                Node delhead = removeHead();
                map.remove(delhead.key);
            }
            addNodetoLast(addnode);
            map.put(key, addnode);
        }
    }

    private Node removeHead() {
        if (head == null)
            return null;
        Node res = head;
        if (head == tail){
            head = null;
            tail = null;
        }else {
            head = res.next;
            head.pre = null;
            res.next = null;
        }

        return res;
    }

    private void addNodetoLast(Node addnode) {
        if (head == null){
            head = addnode;
            tail = addnode;
        }else {
            tail.next = addnode;
            addnode.pre = tail;
            tail = addnode;
            tail.next = null;
        }
    }

    public class Node{
        Node pre;
        Node next;
        V val;
        K key;
        public Node(K key, V val){
            this.val = val;
            this.key = key;
        }
    }

}
