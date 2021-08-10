package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Wardrobe {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 1000000) {
            throw new Exception();
        }
        String thingColors = reader.readLine();
        if (thingColors.equals("")) {
            return;
        }
        if (thingColors.length() == 1) {
            System.out.println(thingColors);
            return;
        }
        int[] colorsArr = Arrays.stream(thingColors.split(" ")).mapToInt(Integer::parseInt).toArray();
        if (colorsArr.length != n) {
            throw new Exception();
        }
        StringBuilder out = new StringBuilder();
        int[] sortedArray = countingSort(colorsArr, 3);
        for (int i = 0; i < sortedArray.length; i++) {
            out.append(sortedArray[i]).append(" ");
        }
        System.out.println(out);
    }

    public static int[] countingSort(int[] arr, int k) throws Exception {
        int[] countedValues = new int[k];
        for (int i = 0; i < arr.length; i++) {
            countedValues[arr[i]]++;
        }
        int index = 0;
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < countedValues[i]; j++) {
                sortedArr[index] = i;
                index++;
            }
        }
        return sortedArr;
    }
}
