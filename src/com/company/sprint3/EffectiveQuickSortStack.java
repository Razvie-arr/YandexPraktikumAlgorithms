package com.company.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class EffectiveQuickSortStack {
    public static void quickSort(ArrayList<Integer> aList, Integer start, Integer end) {
        if (start == null && end == null) {
            start = 0;
            end = aList.size();
        }
        if (end - start > 1) {
            int p = partition(aList, start, end);
            quickSort(aList, start, p);
            quickSort(aList, p + 1, end);
        }
    }

    public static int partition(ArrayList<Integer> aList, int start, int end) {
        int pivot = aList.get(start);
        int i = start + 1;
        int j = end - 1;
        while (true) {
            while (i <= j && aList.get(i) <= pivot) {
                i++;
            }
            while (i <= j && aList.get(j) >= pivot) {
                j--;
            }
            if (i <= j) {
                Collections.swap(aList, i, j);
            }
            else {
                Collections.swap(aList, start, j);
                return j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 100000) {
            throw new Exception("invalid n");
        }
//        String[] names = new String[n];
//        int[] solved = new int[n];
//        int[] penalty = new int[n];
//        for (int i = 0; i < n; i++) {
//            String[] participant = reader.readLine().split(" ");
//            names[i] = participant[0];
//            solved[i] = Integer.parseInt(participant[1]);
//            penalty[i] = Integer.parseInt(participant[2]);
//        }
//
//        System.out.println("names: " + Arrays.toString(names) + ", solved: " + Arrays.toString(solved) + ", penalty: " + Arrays.toString(penalty));
        HashMap<String, ArrayList<Integer>> participants = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] human = reader.readLine().split(" ");
            ArrayList<Integer> scores = new ArrayList<>();
            scores.add(Integer.parseInt(human[1]));
            scores.add(Integer.parseInt(human[2]));
            participants.put(human[0], scores);
        }
        System.out.println(participants);
    }
}
