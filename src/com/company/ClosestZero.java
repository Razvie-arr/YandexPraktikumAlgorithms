package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClosestZero {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 1000000) {
            System.exit(0);
        }
        int[] HouseNumbers = new int[n];
        //HashSet для того, чтобы туда вставлялись только уникальные номера домов
        HashSet <Integer> uniqHouseNumbers = new HashSet<>();
        ArrayList <Integer> HouseNumbersWithoutZero = new ArrayList<>();
        int zero_counter = 0;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int house_number = Integer.parseInt(tokenizer.nextToken());
            if (house_number < 0 || house_number > 1000000000) {
                System.exit(0);
            }
            else if (house_number == 0) {
                zero_counter += 1;
            }
            HouseNumbers[i] = house_number;
            if (HouseNumbers[i] != 0) {
                HouseNumbersWithoutZero.add(house_number);
                uniqHouseNumbers.add(house_number);
            }
        }
        if (zero_counter == 0) {
            System.exit(0);
        }
        //сравниваем длину HashSet с длиной массива, который не включает в себя нули, если эти длины не равны, значит есть неуникальные элементы
        int withoutZeroCounter = 0;
        for(int i = 0; i < HouseNumbersWithoutZero.size(); i++) {
           withoutZeroCounter += 1;
        }
        if (withoutZeroCounter != uniqHouseNumbers.size()) {
            System.exit(0);
        }
        findClosestZero(HouseNumbers);
    }
    public static void findClosestZero(int[] input) {
        int input_lenght = input.length;
        int[] left = new int[input_lenght];
        int[] right = new int[input_lenght];
        int[] result = new int[input_lenght];

        for (int i = 0; i < input_lenght; i++)
        {
            left[i] = input[i] == 0 ? 0 : input_lenght;
            right[i] = input[i] == 0 ? 0 : input_lenght;
        }

        for (int i = 1; i < input_lenght; i++)
            left[i] = input[i] == 0 ? 0 : left[i - 1] + 1;

        for (int i = input_lenght - 2; i >= 0; i--)
            right[i] = input[i] == 0 ? 0 : right[i + 1] + 1;

        for (int i = 0; i < input_lenght; i++)
        {
            result[i] = Math.min(left[i], right[i]);
            System.out.print(result[i] + " ");
        }

    }
}
