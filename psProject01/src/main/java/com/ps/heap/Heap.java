package com.ps.heap;

public class Heap {

    // private List<Integer> heap = new ArrayList<>();
    private int MAX = 10;
    private int[] heap = new int[MAX];

    private int current = 0;
    // Heap() {
    // heap.add(0);
    // }

    private int getParentIndex(int target) {

        return (target / 2);
    }

    private int getRightChildIndex(int target) {
        return target * 2 + 1;
    }

    private int getLeftChildIndex(int target) {
        return target * 2;
    }

    public void insert(int val) {
        if (current + 1 == MAX) {
            System.out.println("out of index");
            return;
        }

        current += 1;
        heap[current] = val;

        int tmp = current;
        while (tmp > 1) {

            if (heap[getParentIndex(tmp)] > val) {
                // swap
                heap[tmp] = heap[getParentIndex(tmp)];
                tmp = getParentIndex(tmp);
                // heap[current] = heap[tmp];
                // heap[tmp] = val;
            } else {
                break;
            }
        }
        heap[tmp] = val;

    }

    public int pop() {

        int tmpIdx = 1;
        int rst = heap[tmpIdx];

        heap[tmpIdx] = heap[current];

        current -= 1;

        while (getLeftChildIndex(tmpIdx) <= current) {

            int rightIdx = getRightChildIndex(tmpIdx);
            int leftIdx = getLeftChildIndex(tmpIdx);

            int rightValue = heap[rightIdx];
            int leftValue = heap[leftIdx];

            int min = Math.min(rightValue, leftValue);

            if (min < heap[tmpIdx]) {

                if (rightValue < leftValue) {
                    swapValue(tmpIdx, rightIdx);
                    tmpIdx = rightIdx;

                } else {
                    swapValue(tmpIdx, leftIdx);
                    tmpIdx = leftIdx;
                }
            } else {
                break;
            }
        }

        return rst;
    }

    private void swapValue(int tmpIdx, int rightIdx) {
        int tmpValue = heap[tmpIdx];
        heap[tmpIdx] = heap[rightIdx];
        heap[rightIdx] = tmpValue;
    }

    public void print() {
        for (int a : heap) {
            System.out.print(a + ",");
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        int[] arr = { 9, 4, 2, 5, 8, 1, 3, 7, 6 };
        // int[] arr = { 9, 4, 2, 5, 8, 1, 3, 7, 6, 10 };

        for (int a : arr) {
            heap.insert(a);
        }
        heap.print();
        System.out.println("");

        for (int a : arr) {

            System.out.print(heap.pop() + ",");
        }
    }
}
