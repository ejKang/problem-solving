package com.ps.dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int y = triangle.size();

        List<Integer> prev = triangle.get(0);
        for (int i = 1; i < y; i++) {

            List<Integer> list = triangle.get(i);
            List<Integer> curr = new ArrayList<>();
            int len = list.size();
            for (int j = 0; j < len; j++) {
                int tmp = list.get(j);
                if (j == 0) {
                    curr.add(tmp + prev.get(0));
                } else if (j == len - 1) {
                    curr.add(tmp + prev.get(prev.size() - 1));
                } else {
                    int min = Math.min(prev.get(j - 1), prev.get(j));
                    curr.add(tmp + min);
                }
            }
            prev = curr;
        }

        return prev.stream().mapToInt(Integer::intValue).min().getAsInt();
    }
}
