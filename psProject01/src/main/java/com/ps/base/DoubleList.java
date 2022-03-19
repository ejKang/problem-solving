package com.ps.base;

public class DoubleList {

    private LRUNode head, tail;
    private int size;

    public DoubleList() {
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(LRUNode node) {

        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;

    }

    public void remove(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public LRUNode removeFirst() {
        if (this.head == this.tail) {
            return null;
        }

        LRUNode first = this.head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}
