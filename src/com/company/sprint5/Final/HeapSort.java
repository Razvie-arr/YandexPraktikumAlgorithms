package com.company.sprint5.Final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public static void heapSort(ArrayList<Participant> participants) {
        ArrayList<Participant> heap = new ArrayList<>();
        for (int i = 1; i < participants.size() ; i++) {
            heapAdd(heap, participants.get(i));
        }
        ArrayList<Participant> sortedParticipants = new ArrayList<>();
        int i = 0;
        while (heap.size() > 0) {
            sortedParticipants.set(i, popMax(heap));
            i++;
        }
        participants.clear();
        participants.addAll(sortedParticipants);
    }

    public static void heapAdd(ArrayList<Participant> heap, Participant participant) {
        int index = heap.size() + 1;
        heap.set(index, participant);
        siftUp(heap, index);
    }

    public static int siftUp(ArrayList<Participant> heap, int index) {
        if (index == 1) {
            return index;
        }
        int parentIndex = index / 2;
        if (comp.compare(heap.get(parentIndex), heap.get(index)) < 0) {
            Participant temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(index));
            heap.set(index, temp);
            index = siftUp(heap, parentIndex);
        }
        return index;
    }

    public static Participant popMax(ArrayList<Participant> heap) {
        Participant result = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        siftDown(heap, 1);
        return result;
    }

    public static int siftDown(ArrayList<Participant> heap, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int n = heap.size() - 1;
        int indexLargest;
        if (n < left) {
            return index;
        }
        if ((right <= n) && (comp.compare(heap.get(left), heap.get(right)) < 0)) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }
        if (comp.compare(heap.get(index), heap.get(indexLargest)) < 0) {
            Participant temp = heap.get(index);
            heap.set(index, heap.get(indexLargest));
            heap.set(indexLargest, temp);
            index = siftDown(heap, indexLargest);
        }
        return index;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 100000) {
            throw new Exception("Wrong n");
        }
        ArrayList<Participant> participants = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            String[] participant = reader.readLine().split(" ");
            int score = Integer.parseInt(participant[1]);
            int penalty = Integer.parseInt(participant[2]);
            participants.set(i, new Participant(participant[0], score, penalty));
        }
        heapSort(participants);
        participants
                .forEach(par -> System.out.println(par.getName()));
    }

}
