package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChaosOfWeather {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String weathers = reader.readLine();
        if (n < 1 || n > 100000) {
            System.exit(0);
        }
        String[] temp = weathers.split(" ");
        int[] weathersArray= new int[temp.length];
        for (int i = 0; i < weathersArray.length; i++) {
            weathersArray[i] = Integer.parseInt(temp[i]);
            if (Math.abs(weathersArray[i]) > 273) {
                System.exit(0);
            }
        }
        if (weathersArray.length != n) {
            System.exit(0);
        }
        findChaoticState(weathersArray);
    }

    public static void findChaoticState(int[] weathersArray) {
        int chaosCounter = 0;
        int arrayLength = weathersArray.length;
        if (arrayLength == 1) {
            System.out.println(1);
            System.exit(0);
        }
        for (int i = 0; i < arrayLength; i++) {
            if (i == 0) {
                if (weathersArray[0] > weathersArray[1]) {
                    chaosCounter += 1;
                }
            }
            else if (i == weathersArray.length - 1) {
                if (weathersArray[i] > weathersArray[i-1]) {
                    chaosCounter += 1;
                }
            }
            else {
                if (weathersArray[i] > weathersArray[i+1] && weathersArray[i] > weathersArray[i-1]) {
                    chaosCounter += 1;
                }
            }

        }
        System.out.println(chaosCounter);
    }
}


