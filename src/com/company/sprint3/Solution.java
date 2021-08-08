package com.company.sprint3;

import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {
//		int[] first = Arrays.copyOfRange(arr, left, mid);
//		int[] second = Arrays.copyOfRange(arr, mid, right);
//		merge_sort(arr, 0, first.length);
//		merge_sort(arr, 0, second.length);
//		merge_sort();
		return null;
	}

	public static void merge_sort(int[] arr, int left, int right) {
		int[] subarray = Arrays.copyOfRange(arr, left, right);

		if (subarray.length == 1) {
			return;
		}
		int[] left_arr = Arrays.copyOfRange(subarray, 0, subarray.length / 2);
		int[] right_arr = Arrays.copyOfRange(subarray, subarray.length / 2, subarray.length);
        int[] left_result = new int[left_arr.length];
        int[] right_result = new int[right_arr.length];

		merge_sort(left_arr, 0, left_arr.length);
		merge_sort(right_arr, 0, right_arr.length);

		int left_l = 0;
		int left_r = 0;
		int left_k = 0;
		while ((left_l < left_arr.length && (left_r < left_arr.length))) {
			if (left_arr[left_l] <= left_arr[left_r]) {
				left_result[left_k] = left_arr[left_l];
				left_l++;
			} else {
                left_result[left_k] = left_arr[left_r];
                left_r++;
			}
			left++;
		}

		while (left_l < left_arr.length) {
            left_result[left_k] = left_arr[left_l];
            left_l++;
            left_k++;
		}
		while (left_r < left_arr.length) {
            left_result[left_k] = left_arr[left_r];
            left_r++;
            left_k++;
		}

		left_arr = left_result;

		int right_l = 0;
		int right_r = 0;
		int right_k = 0;
		while ((right_l < right_arr.length && (right_r < right_arr.length))) {
			if (right_arr[right_l] <= right_arr[right_r]) {
				right_result[right_k] = right_arr[right_l];
				right_l++;
			} else {
				right_result[right_k] = right_arr[right_r];
				right_r++;
			}
			right_k++;
		}

		while (right_l < right_arr.length) {
			right_result[right_k] = right_arr[right_l];
			right_l++;
			right_k++;
		}
		while (right_r < right_arr.length) {
			right_result[right_k] = right_arr[right_r];
			right_r++;
			right_k++;
		}

		right_arr = right_result;

	}

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 2, 10, 11};
		int[] b = merge(a, 0, 3, 6);
		int[] expected = {1, 2, 4, 9, 10, 11};
		assert b.equals(expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert c.equals(expected2);
	}
}