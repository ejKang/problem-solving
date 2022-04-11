package com.ps.graph;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int len = rooms.size();
        boolean[] visited = new boolean[len];

        // recursion version
        canVisitRecursive(rooms, visited, 0);

        // iteration version
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            visited[i] = true;

            for (int key : rooms.get(i)) {
                if (!visited[key]) {
                    stack.push(key);
                }
            }
        }

        // common code
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void canVisitRecursive(List<List<Integer>> rooms, boolean[] visited, int idx) {

        if (idx >= rooms.size()) {
            return;
        }

        visited[idx] = true;
        for (int key : rooms.get(idx)) {
            if (!visited[key]) {
                canVisitRecursive(rooms, visited, key);
            }
        }
    }

    public boolean canVisitAllRooms_2(List<List<Integer>> rooms) {

        int len = rooms.size();
        boolean[] visited = new boolean[len];
        recursive(rooms, visited, 0);

        // iteration version
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            visited[tmp] = true;
            for (int i : rooms.get(tmp)) {
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void recursive(List<List<Integer>> rooms, boolean[] visited, int idx) {

        if (idx >= rooms.size()) {
            return;
        }
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;

        for (int i : rooms.get(idx)) {
            recursive(rooms, visited, i);
        }
    }

    public boolean canVisitAllRooms_3(List<List<Integer>> rooms) {
        int len = rooms.size();
        boolean[] visited = new boolean[len];
        visited[0] = true;

        for (int key : rooms.get(0)) {
            backtracking(rooms, visited, key);
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void backtracking(List<List<Integer>> rooms, boolean[] visited, int key) {

        if (visited[key]) {
            return;
        }

        visited[key] = true;
        for (int k : rooms.get(key)) {
            backtracking(rooms, visited, k);
        }
    }

    public boolean canVisitAllRooms_4(List<List<Integer>> rooms) {

        int len = rooms.size();
        boolean[] visited = new boolean[len];

        backtracking_4(rooms, visited, 0);

        for (boolean vv : visited) {
            if (!vv) {
                return false;
            }
        }
        return true;
    }

    private void backtracking_4(List<List<Integer>> rooms, boolean[] visited, int idx) {

        if (visited[idx]) {
            return;
        }
        List<Integer> target = rooms.get(idx);

        visited[idx] = true;
        for (int room : target) {
            if (!visited[room]) {
                backtracking_4(rooms, visited, room);
            }
        }
    }
}
