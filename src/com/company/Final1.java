package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LimitedDeque {
    Integer[] deque;
    int maxSize;
    int head;
    int tail;
    int size;

    LimitedDeque(int max) {
        deque = new Integer[max];
        maxSize = max;
        head = 0;
        tail = 0;
        size = 0;
    }

    public void push_front(int number) {
        if (size == maxSize)
        {
            System.out.println("error");
            return;
        }
        else if (size == 0) {
            tail = head;
        }
        else {
            head++;
            if (head >= maxSize) {
                head = 0;
            }
        }
        deque[head] = number;
        size++;
    }

    public void push_back(int number) {
        if (size == maxSize)
        {
            System.out.println("error");
            return;
        }
        else if (size == 0) {
            head = tail;
        }
        else {
            tail--;
            if (tail < 0) {
                tail = maxSize - 1;
            }
        }
        deque[tail] = number;
        size++;
    }

    public int pop_front() {
        int temp = deque[head];
        head--;
        if (head < 0) {
            head = maxSize - 1;
        }
        size--;
        return temp;
    }

    public int pop_back() {
        int temp = deque[tail];
        tail++;
        if (tail >= maxSize) {
            tail = 0;
        }
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
public class Final1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        validateConditions(n, m);

        LimitedDeque deque = new LimitedDeque(m);

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.contains("push_front")) {
                int value = findNumberInPushFront(command);
                validateValue(value);
                deque.push_front(value);
            }
            else if (command.contains("push_back")) {
                int value = findNumberInPushBack(command);
                validateValue(value);
                deque.push_back(value);
            }
            else {
                if (deque.isEmpty()) {
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
    private static int findNumberInPushFront(String command) {
        return Integer.parseInt(command.replace("push_front ", ""));
    }
    private static int findNumberInPushBack(String command) {
        return Integer.parseInt(command.replace("push_back ", ""));
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

