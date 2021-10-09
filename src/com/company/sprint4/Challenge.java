package com.company.sprint4;

public class Challenge {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -5, -10, 15};

        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > 0) {
               System.out.println(arr[i]);
           }
        }
    }
}
