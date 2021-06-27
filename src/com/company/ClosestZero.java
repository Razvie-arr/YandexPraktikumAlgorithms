package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ClosestZero {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        if (n < 1 || n > 1000000) {
            System.exit(0);
        }
        int[] HouseNumbers = new int[n];
        //HashSet для того, чтобы туда вставлялись только уникальные номера домов
        HashSet <Integer> uniqHouseNumbers = new HashSet<>();
        ArrayList<Integer> HouseNumbersWithoutZero = new ArrayList<>();
        int zero_counter = 0;

        for (int i = 0; i < n; i++) {
            int house_number = Integer.parseInt(tokenizer.nextToken());
            if (house_number < 0 || house_number > 1000000000) {
                System.exit(0);
            }
            HouseNumbers[i] = house_number;
            if (house_number == 0) {
                zero_counter += 1;
            }
            else {
                HouseNumbersWithoutZero.add(house_number);
                uniqHouseNumbers.add(house_number);
            }
        }
        if (zero_counter == 0) {
            System.exit(0);
        }
        //сравниваем длину HashSet с длиной массива, который не включает в себя нули, если эти длины не равны, значит есть неуникальные элементы
        if (HouseNumbersWithoutZero.size() != uniqHouseNumbers.size()) {
            System.exit(0);
        }
        findClosestZero(HouseNumbers, n);
    }
    public static void findClosestZero(int[] input, int n) {
        StringBuilder result = new StringBuilder();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++)
        {
            left[i] = input[i] == 0 ? 0 : n;
            right[i] = left[i];
            if (i > 0) {
                left[i] = input[i] == 0 ? 0 : left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--)
            right[i] = input[i] == 0 ? 0 : right[i + 1] + 1;

        for (int i = 0; i < n; i++)
        {
            if (left[i] < right[i]) {
               result.append(left[i]).append(" ");
            }
            else {
                result.append(right[i]).append(" ");
            }
        }
        System.out.print(result);
    }
}