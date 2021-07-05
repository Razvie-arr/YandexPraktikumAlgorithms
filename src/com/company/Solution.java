package com.company;

class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class Solution {
    public static Node<String> solution(Node<String> head) {
        int size = 0;
        for (Node<String> n = head; n != null; n = n.next) {
            size++;
        }
        try {
            if (size > 1000) {
                throw new Exception();
            }
            for (Node<String> n = head; n != null; n = n.next) {
                if (n.next == null) {
                    n = head;
                }
                n.prev = n.next;
            }
            return head;
        }
        catch (Exception ignored) {
            return null;
        }
    }

        public static void main(String[] args) {
            Node<String> node3 = new Node<>("node3", null, null);
            Node<String> node2 = new Node<>("node2", node3, null);
            Node<String> node1 = new Node<>("node1", node2, null);
            Node<String> node0 = new Node<>("node0", node1, null);
            Node<String> newNode = solution(node0);
            for (Node<String> n = newNode; n != null; n = n.next) {
                System.out.println(n.value);
            }
        /*
        result is : newNode == node3
        node3.next == node2
        node2.next == node1
        node2.prev == node3
        node1.next == node0
        node1.prev == node2
        node0.prev == node1
        */
        }
    }

