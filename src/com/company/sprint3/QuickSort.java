package com.company.sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(quickSort(new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1))));
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        else {
            Random generator = new Random();
            int randomIndex = generator.nextInt(arr.size());
            int pivot = arr.get(randomIndex);
            ArrayList<Integer> less = getPartition(arr, pivot, "less");
            ArrayList<Integer> center = getPartition(arr, pivot, "center");
            ArrayList<Integer> greater = getPartition(arr, pivot, "greater");
            ArrayList<Integer> output = quickSort(less);
            output.addAll(center);
            output.addAll(quickSort(greater));
            return output;

        }
    }

    public static ArrayList<Integer> getPartition(ArrayList<Integer> arr, int pivot, String type) {
        ArrayList<Integer> newArr = new ArrayList<>();
        switch (type) {
            case "less": {
                for (int j : arr) {
                    if (j < pivot) {
                        newArr.add(j);
                    }
                }
                return newArr;
            }
            case "center": {
                for (int j : arr) {
                    if (j == pivot) {
                        newArr.add(j);
                    }
                }
                return newArr;
            }
            case "greater": {
                for (int j : arr) {
                    if (j > pivot) {
                        newArr.add(j);
                    }
                }
                return newArr;
            }

        }
        return null;
    }
}
