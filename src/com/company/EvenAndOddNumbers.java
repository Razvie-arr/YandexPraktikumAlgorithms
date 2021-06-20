package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EvenAndOddNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int first = Integer.parseInt(tokenizer.nextToken());
        int second = Integer.parseInt(tokenizer.nextToken());
        int third = Integer.parseInt(tokenizer.nextToken());
        System.out.print(even_and_odd_numbers(first, second, third));

    }
    public static String even_and_odd_numbers(int first, int second, int third) {
        if (first % 2 == 0 && second % 2 == 0 && third % 2 == 0) {
            return "WIN";
        }
        else if (first % 2 == 1 && second % 2 == 1 && third % 2 == 1) {
            return "WIN";
        }
        return "FAIL";
    }
}
