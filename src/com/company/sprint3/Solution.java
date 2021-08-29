package com.company.sprint3;

public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        if (right >= left) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            int slice = sliceSearch(arr, left, right);
            int leftToSlice = binarySearch(arr, k, left, slice - 1);
            if (leftToSlice != -1) {
                return leftToSlice;
            } else {
                return binarySearch(arr, k, slice, right);
            }
        }
        return -1;
    }

    public static int sliceSearch(int[] arr, int left, int right) {
        try {
            int mid = (left + right) / 2;
            if (arr[mid + 1] < arr[mid]) {
                return mid + 1;
            }
            if (arr[left] > arr[mid]) {
                int leftToMid = sliceSearch(arr, left, mid);
                if (leftToMid != -1) {
                    return leftToMid + 1;
                }
            }
            return sliceSearch(arr, mid + 1, right) + 1;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {12, 41, 122, 411, 412, 1222, 3000, 12222, 122222, 0, 1, 2, 3, 4, 5};
        System.out.println(brokenSearch(arr, 3000));
    }
}
