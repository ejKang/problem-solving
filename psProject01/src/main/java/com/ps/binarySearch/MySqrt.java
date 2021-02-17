package com.ps.binarySearch;

public class MySqrt {

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        m.mySqrt(8);
        System.out.println("sssss");
    }

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
