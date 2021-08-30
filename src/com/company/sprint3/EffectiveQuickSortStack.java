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
        HashMap<Integer, HashMap<String, String> participants = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] participant = reader.readLine().split(" ");
            HashMap<String, String> name = new HashMap<>();
            name.put("name", participant[0]);
            HashMap<String, Integer> solved = new HashMap<>();
            solved.put("solved", Integer.parseInt(participant[1]);
            HashMap<String, Integer> penalty = new HashMap<>();
            penalty.put("penalty", Integer.parseInt(participant[2]);
            participants.put(i, )
        }
    }
}
