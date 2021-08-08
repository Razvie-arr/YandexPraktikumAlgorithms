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
        int[] colorsArr = Arrays.stream(thingColors.split(" ")).mapToInt(Integer::parseInt).toArray();
        if (colorsArr.length != n) {
            throw new Exception();
        }

        System.out.println(Arrays.toString(countingSort(colorsArr, 2)));
    }

    public static int[] countingSort(int[] arr, int k) {
        int[] countedValues = new int[k + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countedValues[0]++;
            }
            else if (arr[i] == 1) {
                countedValues[1]++;
            }
            else if (arr[i] == 2) {
                countedValues[2]++;
            }
        }

        int index = 0;
        for (int i = 0; i < k ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i])
            }
        }
        return arr;
    }
}
