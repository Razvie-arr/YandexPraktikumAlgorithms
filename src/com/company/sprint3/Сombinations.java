package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Сombinations {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,String> keysMap = new HashMap<>();
        keysMap.put(2, "abc");
        keysMap.put(3, "def");
        keysMap.put(4, "ghi");
        keysMap.put(5, "jkl");
        keysMap.put(6, "mno");
        keysMap.put(7, "pqrs");
        keysMap.put(8, "tuv");
        keysMap.put(9, "wxyz");
        phoneCombinations(reader.readLine(), keysMap);
    }

    public static void phoneCombinations(String inputKeys, Map <Integer, String> keysMap) throws Exception {
        validateKeys(inputKeys);
        int[] inputKeysArr = Arrays.stream(inputKeys.split("")).mapToInt(Integer::parseInt).toArray();
        String[] first = (keysMap.get(inputKeysArr[0])).split("");
        String[] second = (keysMap.get(inputKeysArr[1])).split("");
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                System.out.print(first[i] + "" + second[j] + " ");
            }
        }
    }

    public static void validateKeys(String keys) throws Exception {
        if (!keys.matches("[2-9]+") || (keys.length() > 10)) {
            throw new Exception();
        }
    }
}
