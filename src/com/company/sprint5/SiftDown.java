package com.company.sprint5;

public class SiftDown {
    public static int siftDown(int[] heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;
        int n = heap.length - 1;
        int indexLargest;
        if (n < left) {
            return idx;
        }
        if ((right <= n) && (heap[left] < heap[right])) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }
        if (heap[idx] < heap[indexLargest]) {
            int temp = heap[idx];
            heap[idx] = heap[indexLargest];
            heap[indexLargest] = temp;
            idx = siftDown(heap, indexLargest);
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 10) == 5;
        System.out.println(siftDown(sample, 2));
    }
}