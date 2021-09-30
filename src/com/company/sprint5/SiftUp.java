package com.company.sprint5;

public class SiftUp {
    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return idx;
        }
        int parentIdx = idx / 2;
        if (heap[parentIdx] < heap[idx]) {
            int temp = heap[parentIdx];
            heap[parentIdx] = heap[idx];
            heap[idx] = temp;
            idx = siftUp(heap, parentIdx);
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
        System.out.println(siftUp(sample, 5));
    }
}