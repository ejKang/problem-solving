package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

public class CanVisitAllRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        List<Integer> visited = new ArrayList<>();

        recursiveVisit(visited, rooms, 0);

        if (visited.size() == rooms.size()) {
            return true;
        }
        return false;
    }

    private void recursiveVisit(List<Integer> visited, List<List<Integer>> rooms, int i) {

        visited.add(i);
        List<Integer> list = rooms.get(i);

        for (int idx : list) {
            if (!visited.contains(idx)) {
                recursiveVisit(visited, rooms, idx);
            }
        }
    }

}
