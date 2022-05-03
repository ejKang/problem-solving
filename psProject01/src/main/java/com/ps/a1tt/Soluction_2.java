package com.ps.a1tt;

import java.util.ArrayList;
import java.util.List;

public class Soluction_2 {

    public static int tt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Soluction_2 s = new Soluction_2();
        int[] numbers = { 10, 40, 30, 20 };
        System.out.println(s.solution(numbers, 20));
        System.out.println(tt);
    }

    public int solution(int[] numbers, int k) {

        int min = Integer.MAX_VALUE;
        int changeCnt = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > k) {
                // check valide nums
                List<Integer> list = new ArrayList<>();
                for (int j = i + 2; j < numbers.length; j++) {
                    if (Math.abs(numbers[i + 1] - numbers[j]) <= k) {
                        list.add(j);
                    }
                }

                for (int j : list) {
                    swap(numbers, i, j);
                    validecheck(numbers, k, min, i + 1, changeCnt + 1);
                    swap(numbers, i, j);
                }

            } else {
                validecheck(numbers, k, min, i + 1, changeCnt);
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private void validecheck(int[] numbers, int k, int min, int idx, int changeCnt) {
        if (idx == numbers.length - 2) {
            if (Math.abs(numbers[idx] - numbers[idx + 1]) <= k) {
                tt = Math.min(tt, changeCnt);
            }

            return;
        }

        for (int i = idx; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > k) {
                // check valide nums
                List<Integer> list = new ArrayList<>();
                for (int j = i + 2; j < numbers.length; j++) {
                    if (Math.abs(numbers[i + 1] - numbers[j]) <= k) {
                        list.add(j);
                    }
                }
                for (int j : list) {
                    swap(numbers, i, j);
                    validecheck(numbers, k, min, i + 1, changeCnt + 1);
                    swap(numbers, i, j);
                }

            } else {
                validecheck(numbers, k, min, i + 1, changeCnt);
            }
        }

    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];

        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
