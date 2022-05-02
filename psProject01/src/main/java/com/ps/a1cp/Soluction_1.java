package com.ps.a1cp;

public class Soluction_1 {

    // 주어진 sequence 배열이 원형으로 연결되어 있고, 각 노드로 이동하는데는 1이라는 시간이 소요된다.
    public int sol(int N, int[] sequence) {

        int len = sequence.length;
        int rst = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && sequence[i] == 1) {
                continue;
            } else if (i == 0) {
                int right = sequence[i] - 1;
                int left = N - sequence[i] + 1;
                rst += Math.min(right, left);
                continue;

            }
            int right = sequence[i] - sequence[i - 1];
            int left = N - sequence[i] + sequence[i - 1];
            rst += Math.min(right, left);
        }
        return rst;
    }
}
