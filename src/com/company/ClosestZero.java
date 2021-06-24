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
        int lenghtofSet = uniqHouseNumbers.size();
        int withoutZeroCounter = 0;
        for(int i = 0; i < HouseNumbersWithoutZero.size(); i++) {
           withoutZeroCounter += 1;
        }
        if (withoutZeroCounter != lenghtofSet) {
            System.exit(0);
        }
        findClosestZero(HouseNumbers);
    }
    public static void findClosestZero(int[] HouseNumbers) {
        for (int i : HouseNumbers) {
            System.out.println(i);
        }
    }
}
