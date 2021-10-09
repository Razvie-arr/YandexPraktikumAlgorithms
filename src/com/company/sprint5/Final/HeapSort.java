/*
https://contest.yandex.ru/contest/24810/run-report/53815830/
-- ПРИНЦИП РАБОТЫ --
Присутствует класс Participant, хранящий в себе имя, баллы и штрафы каждого участника.
Используя просеивание вниз конструктируем бинарную кучу и производим сортировку.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность O(n log n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
В основном используется O(n) для хранения массива, особо дополнительной памяти не требуется.
 */
package com.company.sprint5.Final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class HeapSort {
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
                    .thenComparingInt(Participant::getPenalty).thenComparing(Participant::getName);

    public static void sort(Participant[] arr)
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            siftDown(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Participant temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            siftDown(arr, i, 0);
        }
    }

    static void siftDown(Participant[] arr, int n, int index)
    {
        int indexLargest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && comp.compare(arr[left], arr[indexLargest]) > 0)
            indexLargest = left;

        if (right < n && comp.compare(arr[right], arr[indexLargest]) > 0)
            indexLargest = right;

        if (indexLargest != index) {
            Participant swap = arr[index];
            arr[index] = arr[indexLargest];
            arr[indexLargest] = swap;

            siftDown(arr, n, indexLargest);
        }
    }

    static void printArray(Participant[] arr)
    {
        StringBuilder out = new StringBuilder();
        for (Participant participant : arr) {
            out.append(participant.getName()).append("\n");
        }
        out.setLength(out.length() - 1);
        System.out.println(out);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 100000) {
            throw new Exception("Wrong n");
        }
        Participant[] participants = new Participant[n];
        for (int i = 0; i < n; i++) {
            String[] participant = reader.readLine().split(" ");
            int score = Integer.parseInt(participant[1]);
            int penalty = Integer.parseInt(participant[2]);
            if (score < 0 || score > 1000000000) {
                throw new Exception("Wrong score");
            }
            if (penalty < 0 || penalty > 1000000000) {
                throw new Exception("Wrong penalty");
            }
            participants[i] = new Participant(participant[0], score, penalty);
        }
        sort(participants);
        printArray(participants);
    }
}
