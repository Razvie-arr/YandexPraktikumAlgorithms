package com.company.sprint3;

import java.util.Arrays;

public class Solution {
    public static int brokenSearch(int[] arr, int k) { ;
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        else if (arr.length == 1) {
            if (arr[0] == k) {
                return mid;
            }
        }
        else if (arr.length == 2) {
            if (arr[0] == k) {
                return 0;
            }
            else if (arr[1] == k) {
                return 1;
            }
        }
        else if (arr[left] <= arr[mid]) {
            if (k <= arr[mid]) {
                return brokenSearch(Arrays.copyOfRange(arr,left, mid + 1), k);
            }
            else {
                return brokenSearch(Arrays.copyOfRange(arr, mid + 1, right + 1), k);
            }
        }
        else {
            if (k <= arr[mid]) {
                return brokenSearch(Arrays.copyOfRange(arr,left, mid), k);
            }
            else {
                int leftToMid= brokenSearch(Arrays.copyOfRange(arr,left, mid + 1), k);
                if (leftToMid != -1) {
                    return leftToMid + left;
                }
                int midToRight = brokenSearch(Arrays.copyOfRange(arr, mid + 1, right + 1), k);

                if (midToRight != -1) {
                    return midToRight + mid + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 9, 0};
        System.out.println(brokenSearch(arr, 3));
    }
}
