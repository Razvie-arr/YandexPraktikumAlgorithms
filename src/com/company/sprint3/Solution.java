package com.company.sprint3;

import java.util.Arrays;

public class Solution {
    public static int brokenSearch(int[] arr, int k) { ;
        int left = 0;
        int right = arr.length - 1;
        int mid = arr.length / 2;
        if (arr[mid] == k) {
            return mid;
        }
        else if (arr.length == 1) {
            if (arr[0] == k) {
                return k;
            }
        }
        else if (arr[left] <= arr[mid]) {
            if (k <= arr[mid]) {
                return brokenSearch(Arrays.copyOfRange(arr,0, mid), k);
            }
            else {
                return brokenSearch(Arrays.copyOfRange(arr, mid, right + 1), k);
            }
        }
        else {
            if (k <= arr[mid]) {
                right = mid;
                return brokenSearch(Arrays.copyOfRange(arr,0, right), k);
            }
            else {
                int leftToMid= brokenSearch(Arrays.copyOfRange(arr,0, mid), k);
                if (leftToMid != -1) {
                    return leftToMid;
                }
                int midToRight = brokenSearch(Arrays.copyOfRange(arr, mid, right + 1), k);

                if (midToRight != -1) {
                    return midToRight + mid + 1;
                }
                else {
                    return -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        System.out.println(brokenSearch(arr, 5));
    }
}
