package com.company.sprint3;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        insertionSort(array);
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int itemToInsert = array[i];
            int j = i;
            while ((j > 0) && (itemToInsert < array[j-1])) {
                array[i] = array[j - 1];
                j -= 1;
            }
            array[j] = itemToInsert;
            System.out.println("step " + i + ", sorted " + (i + 1) + " elements: " + Arrays.toString(array));
        }
    }
}