package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class LimitedDeque2 {
    Integer[] deque;
    int maxSize;
    int head;
    int tail;
    int size;

    LimitedDeque2(int max_size) {
        deque = new Integer[max_size];
        Arrays.fill(deque, null);
        this.maxSize = max_size;
        head = 0;
        tail = deque.length - 1;
        size = 0;
    }

    public void push_front(int number) {
        if (size != maxSize) {
            deque[head] = number;
            if (head == deque.length - 1) {
                head = 0;
            }
            else {
                head = head + 1 % maxSize;
            }
            size++;
        }
        else {
            System.out.println("error");
        }
    }

    public void push_back(int number) {
        if (size != maxSize) {
            deque[tail] = number;
            if (tail == 0) {
                tail = deque.length - 1;
            }
            else {
                tail = (tail - 1) % maxSize;
            }
            size++;
        }
        else {
            System.out.println("error");
        }
    }

    public int pop_front() {
        if (head == 0) {
            head = tail;
            int number = deque[head + 1];
            deque[head + 1] = null;
            head = (head - 1) % maxSize;
            size--;
            return number;
        }
        else {
            int number = deque[head - 1];
            deque[head - 1] = null;
            head = (head - 1) % maxSize;
            size--;
            return number;
        }
    }

    public int pop_back() {
        if (tail == deque.length - 1) {
            tail = 0;
            int number = deque[tail];
            deque[tail] = null;
            size--;
            return number;
        }
        else {
            int number = deque[tail + 1];
            deque[tail + 1] = null;
            tail = (tail + 1) % maxSize;
            size--;
            return number;
        }
    }
}

public class Final1_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        validateConditions(n, m);

        LimitedDeque2 deque = new LimitedDeque2(m);

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.contains("push_back")) {
                int value = findNumberInCommand(command);
                validateValue(value);
                deque.push_back(value);
            }
            else if (command.contains("push_front")) {
                int value = findNumberInCommand(command);
                validateValue(value);
                deque.push_front(value);
            }
            else {
                if (deque.size == 0) {
                    System.out.println("error");
                }
                else {
                    switch (command) {
                        case("pop_front"):
                            System.out.println(deque.pop_front());
                            break;
                        case("pop_back"):
                            System.out.println(deque.pop_back());
                            break;
                    }
                }
            }
        }
    }
    private static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }
    public static void validateConditions(int n, int m) throws Exception {
        if (n > 5000 || m > 1000) {
            throw new Exception();
        }
    }
    public static void validateValue(int value) throws Exception {
        if (Math.abs(value) > 1000) {
            throw new Exception();
        }
    }
}

