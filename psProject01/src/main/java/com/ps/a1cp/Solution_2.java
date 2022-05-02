package com.ps.a1cp;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 s = new Solution_2();
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[] t = s.sol(arr);
        for (int i : t) {
            System.out.print(i + ",");
        }
        // System.out.println(s.sol(arr));
    }

    public int[] sol(int[] arr) {

        return recursive(arr, 0, arr.length - 1);
    }

    private int[] recursive(int[] arr, int start, int end) {

        if (start == end) {
            return arr;
        } else if (start > end) {
            return arr;
        }
        int mid = start + (end - start) / 2;
        System.out.println(start + ", " + end + ", " + mid);
        // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // Collections.reverse(list);
        // arr = list.toArray(new int[list.size()]);
        reverse(arr, start, end);

        if ((end - start + 1) % 2 == 0) {
            recursive(arr, start, mid);
            recursive(arr, mid + 1, end);
        } else {
            recursive(arr, start, mid);
            recursive(arr, mid + 1, end);
        }
        return arr;
    }

    private void reverse(int[] arr, int start, int end) {

        int mid = start + (end - start) / 2;
        int t = 0;
        for (int i = start; i <= mid; i++) {
            int tmp = arr[i];
            arr[i] = arr[end - t];
            arr[end - t] = tmp;
            t++;
        }
    }
}
