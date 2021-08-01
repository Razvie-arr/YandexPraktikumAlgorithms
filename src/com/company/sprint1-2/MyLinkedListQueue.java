//package com.company;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//class QueueNode<V> {
//    public V value;
//    public QueueNode<V> next;
//    public QueueNode<V> prev;
//
//    public QueueNode(V value, QueueNode<V> next) {
//        this.value = value;
//        this.next = next;
//    }
//
//    public QueueNode(String item) {
//    }
//}
//
//public class MyLinkedList {
//
//    QueueNode head;
//
//    public MyLinkedList(String item) {
//
//        head = new QueueNode(item);
//
//    }
//
//    public void add(String item) {
//
//        //pseudo code: while next isn't null, walk the list
//        //once you reach the end, create a new LinkNode and add the item to it.  Then
//        //set the last LinkNode next to this new LinkNode
//
//    }
//
//
//}
//public class MyLinkedListQueue {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int commandCount = Integer.parseInt(reader.readLine());
//        if (commandCount > 1000) {
//            throw new Exception();
//        }
//        LinkedList<Integer> linkedQueue = new LinkedList<>();
//        for (int i = 0; i < commandCount; i++) {
//            String command = reader.readLine();
//            if (command.contains("put")) {
//                int number = findNumberInCommand(command);
//                linkedQueue.add(number);
//            }
//            if (command.equals("size")) {
//                System.out.println(linkedQueue.size());
//            }
//            if (command.equals("get")) {
//                if (linkedQueue.size() == 0) {
//                    System.out.println("error");
//                }
//                else {
//                    System.out.println(linkedQueue.poll());
//                }
//            }
//        }
//    }
//
//    public static int findNumberInCommand(String command) {
//        String[] splittedCommand = command.split(" ");
//        return Integer.parseInt(splittedCommand[1]);
//    }
//}
