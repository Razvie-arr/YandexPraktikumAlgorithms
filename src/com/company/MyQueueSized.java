package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyQueueSized {
    int max_n;
    int head;
    int tail;
    int size;
    Integer[] queue;
    public MyQueueSized(int max_n) {
        queue = new Integer[max_n];
        Arrays.fill(queue, null);
        this.max_n = max_n;
        head = 0;
        tail = 0;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Integer push(int number) {
        if (size != max_n) {
            queue[tail] = number;
            tail = (tail + 1) % max_n;
            size++;
        }
        else {
            return null;
        }
        return 1;
    }
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        int number = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        return number;
    }
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[head];
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        int queueSize = Integer.parseInt(reader.readLine());
        if (commandCount > 5000 || queueSize > 5000) {
            throw new Exception();
        }
        MyQueueSized queue = new MyQueueSized(queueSize);
        for (int i = 0; i < commandCount; i++) {
            String command = reader.readLine();
            if (command.contains("push")) {
                int number = findNumberInCommand(command);
                if (queue.push(number) == null) {
                    System.out.println("error");
                }
            }
            else {
                switch (command) {
                    case "peek":
                        Integer peeked = queue.peek();
                        if ((peeked == null)) {
                            System.out.println("None");
                        } else {
                            System.out.println(peeked);
                        }
                        break;
                    case "pop":
                        if (queue.isEmpty()) {
                            System.out.println("None");
                        } else {
                            System.out.println(queue.pop());
                        }
                        break;
                    case "size":
                        System.out.println(queue.size());
                        break;
                    default:
                        throw new Exception();
                }
            }
        }
    }
    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }
}

