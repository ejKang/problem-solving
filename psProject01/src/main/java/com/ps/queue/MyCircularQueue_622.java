package com.ps.queue;

public class MyCircularQueue_622 {

    private int[] arr;
    private int front = 0;
    private int rear = -1;

    private int size;
    private int currentSize;

    public MyCircularQueue_622(int k) {
        arr = new int[k];
        size = k;
        currentSize = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % size;
        arr[rear] = value;
        currentSize++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        currentSize--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }

    public boolean isFull() {
        return currentSize == size ? true : false;
    }

}
