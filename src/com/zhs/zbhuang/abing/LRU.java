package com.zhs.zbhuang.abing;

import java.util.Hashtable;

public class LRU {
    Integer size;
    Integer capacity;
    Node head, tail;
    Hashtable<Integer, Node> map = new Hashtable<>();

    public LRU(Integer capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    Node popTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;
    }

    public Integer get(Integer key) {
        Node node = map.get(key);
        if(null == node) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(Integer key, Integer value){
        Node node = map.get(key);
        if(null == node) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            addNode(newNode);
            ++size;
            if(size > capacity) {
                Node tail = popTail();
                removeNode(tail);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

}
