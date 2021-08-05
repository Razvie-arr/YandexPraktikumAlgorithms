package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String inputNumbers = reader.readLine();
        int[] array = Arrays.stream(inputNumbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n < 2 || n > 1000 || n != array.length) {
            throw new Exception();
        }
        sort(array);
    }

    public static void sort(int[] array) throws Exception {
        int temp;
        String str;
        boolean switched = false;
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > 1000) {
                    throw new Exception();
                }
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    switched = true;
                    counter++;
                }
            }
            if (switched) {
                StringBuilder out = new StringBuilder();
                for (int j = 0; j < array.length; j++) {
                    out.append(array[j]).append(" ");
                }
                System.out.println(out);
            }
            switched = false;
        }
        if (counter == 0) {
            str = Arrays.toString(array);
            str = str.substring(1, str.length() - 1);
            System.out.println(str.replaceAll(",", ""));
        }
    }
}
