package com.company.sprint5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class selfCheck {
    public static ArrayList<Integer> BSF(Node head) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> values = new ArrayList<>();
        queue.add(head);
        while (queue.size() > 0) {
            Node tempNode = queue.poll();
            values.add(tempNode.value);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return values;
    }

    public static void preOrder(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(Node head) {
        if (head == null) return;
        inOrder(head.left);
        System.out.print(head.value + " ");;
        inOrder(head.right);
    }

    public static void postOrder(Node head) {
        if (head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.value + " ");;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        System.out.println("BSF: " + BSF(node4));
        System.out.print("preOrder: ");
        preOrder(node4);
        System.out.println();
        System.out.print("inOrder: ");
        inOrder(node4);
        System.out.println();
        System.out.print("postOrder: ");
        postOrder(node4);
        System.out.println();

    }
}
