package com.company.sprint3;

import java.util.Arrays;

public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        if (arr[left] <=)
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                index = mid;
                break;
            }
            else if (arr[mid] < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return index;


    }

    public static void main(String[] args) {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        System.out.println(brokenSearch(arr, 5));
    }
}
