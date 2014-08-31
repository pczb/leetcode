package com.tiger.leetcode;

import java.util.HashMap;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class LRUCache{
    int capacity;
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int value){
            Node.this.key = key;
            Node.this.value = value;
            Node.this.prev = null;
            Node.this.next = null;
        }
    }

    int used;
    Node head,tail;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }



    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node.prev == head) return node.value;
            else{
                Node prevNode = node.prev;
                Node nextNode = node.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                Node headNextNode = head.next;
                head.next = node;
                node.prev = head;
                node.next = headNextNode;
                headNextNode.prev = node;
                return node.value;
            }
        }
        return -1;
    }

    private void removeLast(){
        if(tail.prev != head){
            Node prevNode = tail.prev;
            prevNode.prev.next = tail;
            tail.prev = prevNode.prev;
            map.remove(prevNode.key);
            used--;
        }

    }

    public void set(int key, int value) {
        if(!map.containsKey(key)){
            if(used == capacity){
                removeLast();
            }
            Node node = new Node(key,value);
            Node nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            map.put(key,node);
            used++;
        }
        else{
            map.get(key).value = value;
            get(key);
        }

    }
}

