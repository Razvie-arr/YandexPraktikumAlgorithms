package com.company.spint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Heap implements Comparable<Heap> {
    private final int costOfKilogram;
    private final int kilograms;

    public Heap(int costOfKilogram, int kilograms) {
        this.costOfKilogram = costOfKilogram;
        this.kilograms = kilograms;
    }

    public int getCostOfKilogram() {
        return costOfKilogram;
    }

    public int getKilograms() {
        return kilograms;
    }

    @Override
    public int compareTo(Heap heap) {
        return Integer.compare(this.costOfKilogram, heap.getCostOfKilogram());
    }
}

public class GoldenFever {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        List<Heap> heaps = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            int costOfKilogram = Integer.parseInt(tokenizer.nextToken());
            int kilograms = Integer.parseInt(tokenizer.nextToken());
            heaps.add(new Heap(costOfKilogram, kilograms));
        }
        System.out.println(getMaxSum(heaps, M));
    }

    public static int getMaxSum(List<Heap> heaps, int M) {
        Collections.sort(heaps);
        Collections.reverse(heaps);
        int kg = 0;
        int sum = 0;
        for (Heap heap : heaps) {
            if (kg < M) {
                for (int j = 0; j < heap.getKilograms(); j++) {
                    if (kg < M) {
                        sum += heap.getCostOfKilogram();
                        kg++;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
