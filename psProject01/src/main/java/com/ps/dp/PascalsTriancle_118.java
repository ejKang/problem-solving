package com.ps.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriancle_118 {

    // time complexity - o(n^2)
    // dynamic programming - bottom up
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> list = new ArrayList<>();
            // List<Integer> prev = null;

            // if (i > 0) {
            // prev = rst.get(rst.size() - 1);
            // }

            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    // int tmp = prev.get(j - 1) + prev.get(j);
                    int tmp = rst.get(rst.size() - 1).get(j - 1) + rst.get(rst.size() - 1).get(j);
                    list.add(tmp);
                }

            }
            rst.add(list);
        }
        return rst;
    }

    public List<List<Integer>> generate_2(int numRows) {

        List<List<Integer>> rst = new ArrayList<>();

        List<Integer> prev = null;
        for (int i = 1; i < numRows + 1; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                if (j == 0) {
                    list.add(1);
                } else if (j == i - 1) {
                    list.add(1);
                } else {
                    int tmp = prev.get(j - 1) + prev.get(j);
                    list.add(tmp);
                }
            }
            rst.add(list);
            prev = list;
        }

        return rst;
    }
}
