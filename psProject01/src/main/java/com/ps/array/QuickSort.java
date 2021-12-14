package com.ps.array;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort quick = new QuickSort();
        int[] arr = { 9, 2, 5, 4, 7, 6, 8 };

        System.out.println("Before : ");
        System.out.println(Arrays.toString(arr));
        quick.quicksort(arr, 0, arr.length - 1);

        System.out.println("After : ");
        System.out.println(Arrays.toString(arr));
    }

    // time complex O(nlogn)
    private void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quicksort(arr, left, pivot - 1);
            quicksort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int low = left;
        int hight = right;

        int pivot = arr[left];

        while (low < hight) {
            while (arr[hight] > pivot && hight > low) {
                hight--;
            }

            while (arr[low] <= pivot && hight > low) {
                low++;
            }

            swap(hight, low, arr);
        }

        swap(left, low, arr);
        return low;
    }

    private void swap(int hight, int low, int[] arr) {
        int temp = arr[hight];
        arr[hight] = arr[low];
        arr[low] = temp;
    }
}
