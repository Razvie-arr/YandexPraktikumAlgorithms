package com.company.sprint3;

import java.util.*;

public class EffectiveQuickSort {
    public static ArrayList<Integer> effectiveQuickSort(ArrayList<Integer> arr, Integer start, Integer end) {
        if (start == null && end == null) {
            start = 0;
            end = arr.size() - 1;
        }
        if (end - start > 1) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(arr.size());
            int pivot = arr.get(randomIndex);
            int partition = getPartition(arr, pivot, start, end);
            ArrayList<Integer> less = effectiveQuickSort(arr, start, partition);
            List<Integer> lessSub = less.subList(start, partition);
            ArrayList<Integer> greater = effectiveQuickSort(arr, partition, end);
            List<Integer> greaterSub = greater.subList(partition, end);
            lessSub.addAll(greaterSub);
            return (ArrayList<Integer>) lessSub;
        }
        else {
            return arr;
        }
    }

    public static int getPartition(ArrayList<Integer> arr, int pivot, int start, int end) {
        boolean startInc = false;
        boolean endDec = false;
        while (start < end) {
            if (arr.get(start) < pivot) {
                start++;
                startInc = true;
            }
            if (arr.get(end) > pivot) {
                end--;
                endDec = true;
            }
            if (!startInc && !endDec) {
                Collections.swap(arr, start, end);
                start++;
                end--;
            }

            startInc = false;
            endDec = false;
        }
        return start;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 8, 9, 20, 1, 5, 3, 10));
        System.out.println(effectiveQuickSort(arr, null, null).toString());
    }
}
