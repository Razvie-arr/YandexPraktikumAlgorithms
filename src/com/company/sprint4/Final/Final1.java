package com.company.sprint4.Final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Entry {
    private final int key;
    private int value;
    private Entry next;

    public Entry(int key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}

class MyHashMap {
    private final int capacity;
    private final Entry[] table;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public void put(int key, int value) {
        int index = index(key);
        Entry newEntry = new Entry(key, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry previousNode = null;
            Entry currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previousNode != null) {
                previousNode.setNext(newEntry);
            }
        }
    }

    public Integer get(int key) {
        Integer value = null;
        int index = index(key);
        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    public Integer delete(int key) {
        int index = index(key);
        Integer value = null;
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                if (previous == null) {
                    entry = entry.getNext();
                    table[index] = entry;
                } else {
                    previous.setNext(entry.getNext());
                }
                return value;
            }
            previous = entry;
            entry = entry.getNext();
        }
        return value;
    }

    private int index(Integer key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}


public class Final1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        MyHashMap customMap = new MyHashMap(n / 2);
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.contains("get")) {
                Integer receivedValue = customMap.get(findNumberInCommand(command, 1));
                if (receivedValue == null) {
                    output.append("None").append("\n");
                } else {
                    output.append(receivedValue).append("\n");
                }
            }
            if (command.contains("put")) {
                customMap.put(findNumberInCommand(command, 1), findNumberInCommand(command, 2));
            }
            if (command.contains("delete")) {
                Integer deletedValue = customMap.delete(findNumberInCommand(command, 1));
                if (deletedValue == null) {
                    output.append("None").append("\n");
                } else {
                    output.append(deletedValue).append("\n");
                }
            }
        }
        output.setLength(output.length() - 1);
        System.out.println(output);
    }

    public static int findNumberInCommand(String command, int n) {
        final Pattern pattern = Pattern.compile("\\d+");
        final Matcher matcher = pattern.matcher(command);

        final int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            matcher.find();
            ints[i] = Integer.parseInt(matcher.group());
        }
        if (n == 1) {
            return ints[0];
        }
        return ints[1];
    }
}
