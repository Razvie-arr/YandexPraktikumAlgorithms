package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Answer {
    public static class Participant {
        private final String name;
        private final int score;
        private final int penalty;

        public Participant(String name, int score, int penalty) {
            this.name = name;
            this.score = score;
            this.penalty = penalty;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getPenalty() {
            return penalty;
        }
    }

    public static Comparator<Participant> comp =
            Comparator.comparingInt(Participant::getScore).reversed()
                    .thenComparingInt(Participant::getPenalty);

    public static void quickSort(List<Participant> aList, int start,
                                 int end) {

        if (end - start > 1) {
            int p = partition(aList, start, end);
            quickSort(aList, start, p);
            quickSort(aList, p + 1, end);
        }
    }

    public static int partition(List<Participant> aList, int start,
                                int end) {
        Participant pivot = aList.get(start);
        int i = start + 1;
        int j = end - 1;
        while (true) {
            while (i <= j && comp.compare(aList.get(i), pivot) <= 0) {
                i++;
            }
            while (i <= j && comp.compare(aList.get(j), pivot) >= 0) {
                j--;
            }
            if (i <= j) {
                Collections.swap(aList, i, j);
            } else {
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
        List<Participant> participants = new ArrayList<>();
        int zeroCounter = 0;
        for (int i = 0; i < n; i++) {
            String[] participant = reader.readLine().split(" ");
            int score = Integer.parseInt(participant[1]);
            int penalty = Integer.parseInt(participant[2]);
            participants.add(new Participant(participant[0], score, penalty));
            if (score == 0 && penalty == 0) {
                zeroCounter++;
            }
        }
        quickSort(participants, 0, participants.size());
        if (zeroCounter == n && participants.size() != 2) {
            System.out.println(participants.get(n - 1).getName());
            for (int i = 0; i < n - 1; i++) {
                System.out.println(participants.get(i).getName());
            }
        } else {
            participants
                    .forEach(par -> System.out.println(par.getName()));
        }
    }
}
