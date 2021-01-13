package com.ps.binarySearch;

public class Search {
    
    public static void main(String[] args) {
        Search s = new Search();
        int[] a ={4,5,6,7,0,1,2};

        s.search(a, 3);
    }
    public int search(int[] nums, int target) {
        // find min value index ( rotation point )
        int start = 0, end = nums.length -1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) /2 ;
            if (nums[mid]> nums[end]) {
                start = mid + 1;
            } else {
                end = mid ;
            }
        }
        // current start is rotation point ! 
        int point = start ; 
        if (nums[point] == target) return point;
        if (target <= nums[nums.length -1]) {
            start = point;
            end = nums.length -1;
        } else {
            start = 0; 
            end = point -1;
        }

        while ( start <= end) {
            mid = start + (end - start) /2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) {
                start = mid +1 ;
            } else {
                end = mid -1 ;
            }
        }

        return -1;
    }
}
