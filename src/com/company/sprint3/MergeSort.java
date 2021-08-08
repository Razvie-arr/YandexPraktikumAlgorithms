package com.company.sprint3;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(mergeSort(new int[]{5, 4, 3, 2, 1})));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));
        int[] result = new int[array.length];

        int l = 0;
        int r = 0;
        int k = 0;
        while ((l < left.length) && (r < right.length)) {
            if (left[l] <= right[r]) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }

        while (l < left.length) {
            result[k] = left[l];
            l++;
            k++;
        }
        while (r < right.length) {
            result[k] = right[r];
            r++;
            k++;
        }

        return result;
    }
}
