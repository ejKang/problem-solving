package com.ps.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn_740 {

    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] rst = new int[max + 1];

        for (int num : nums) {
            rst[num] += num;
        }
        int current = 0;
        int previous = 0;

        for (int i = 0; i < max + 1; i++) {
            int tmp = current;
            current = Math.max(current, previous + rst[i]);
            previous = tmp;
        }

        return Math.max(current, previous);
    }

    public int deleteAndEarn_2(int[] nums) {

        int max = Arrays.stream(nums).max().getAsInt();
        int[] rst = new int[max + 1];

        for (int num : nums) {
            rst[num] += num;
        }
        Map<Integer, Integer> map = new HashMap<>();
        dp(rst, max + 1, 0, map);
        return map.get(0);
    }

    private int dp(int[] rst, int len, int i, Map<Integer, Integer> map) {

        if (i >= len) {
            return 0;
        }

        if (map.containsKey(i)) {
            return map.get(i);
        }

        int tmp = Math.max(rst[i] + dp(rst, len, i + 2, map), dp(rst, len, i + 1, map));
        map.put(i, tmp);

        return tmp;
    }
}
