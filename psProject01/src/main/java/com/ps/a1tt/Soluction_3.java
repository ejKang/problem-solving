package com.ps.a1tt;

import java.util.ArrayList;
import java.util.List;

public class Soluction_3 {

    public static int tt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Soluction_3 s = new Soluction_3();
        int[] numbers = { 10, 40, 30, 20 };
        System.out.println(s.solution(numbers, 20));
        System.out.println(tt);
    }

    public int solution(int[] numbers, int k) {

        

        return 1;
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];

        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
