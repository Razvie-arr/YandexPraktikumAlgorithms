package com.company.sprint3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EffectiveQuickSort {
    public static List<Integer> effectiveQuickSort(List<Integer> arr, Integer start, Integer end) {
        if (end - start > 0) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(end);
            int pivot = arr.get(randomIndex);
            int partition = getPartition(arr, pivot, start, end);
            List<Integer> lessSlice = arr.subList(start, partition);
            List<Integer> greaterSlice = arr.subList(partition, end + 1);
            lessSlice = effectiveQuickSort(lessSlice, 0, lessSlice.size() - 1);
            greaterSlice = effectiveQuickSort(greaterSlice, 0, greaterSlice.size() - 1);
            List<Integer> output = Stream.concat(lessSlice.stream(), greaterSlice.stream())
                    .collect(Collectors.toList());
            return output;
        }
        else {
            return arr;
        }
    }

    public static int getPartition(List<Integer> arr, int pivot, int start, int end) {
        boolean startInc = false;
        boolean endDec = false;
        while (start < end) {
            if (arr.get(start) <= pivot) {
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
//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 8, 9, 20, 1, 5, 3, 10));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(100, 1000, 90, 90, 4, 80));

        System.out.println(effectiveQuickSort(arr, 0, arr.size() - 1));
    }
}
