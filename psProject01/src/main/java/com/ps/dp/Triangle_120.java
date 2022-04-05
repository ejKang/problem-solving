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

    public int minimumTotal_2(List<List<Integer>> triangle) {

        int len = triangle.size();

        List<Integer> prev = triangle.get(0);

        if (len == 1) {
            return prev.get(0);
        }
        for (int i = 1; i < len; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> rst = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {

                if (j == 0) {
                    rst.add(prev.get(0) + list.get(0));
                } else if (j == list.size() - 1) {
                    rst.add(prev.get(j - 1) + list.get(j));
                } else {
                    int tmp = Math.min(prev.get(j - 1), prev.get(j));
                    rst.add(tmp + list.get(j));
                }
            }
            prev = rst;
        }

        return prev.stream().min((a, b) -> a - b).get();
    }
}
