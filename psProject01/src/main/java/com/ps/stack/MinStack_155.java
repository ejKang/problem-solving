package com.ps.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack_155 {

    private List<Integer> list;
    private List<Integer> minList;
    private int[] arr;
    private int[] min;

    int a, m;

    public MinStack_155() {
        arr = new int[1000];
        min = new int[1000];

        list = new ArrayList<>();
        minList = new ArrayList<>();

        a = -1;
        m = 0;
    }

    public void push(int val) {
        list.add(val);
        arr[a + 1] = val;

        if (a == -1) {
            min[a + 1] = val;
            minList.add(val);
        } else if (minList.get(a) > val) {
            min[a + 1] = val;
            minList.add(val);
        } else {
            min[a + 1] = min[a];
            minList.add(minList.get(a));
        }

        a++;

    }

    public void pop() {
        list.remove(a);
        minList.remove(a);
        arr[a] = 0;
        min[a] = 0;
        a--;

    }

    public int top() {
        return list.get(a);
    }

    public int getMin() {
        return minList.get(a);
    }

}
