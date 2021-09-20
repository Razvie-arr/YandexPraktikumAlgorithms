package com.company.sprint5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int treeSolution(Node head) {
        int maxValue = head.value;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(queue.size() > 0){
            Node tempNode = queue.poll();
            if (tempNode.value > maxValue) {
                maxValue = tempNode.value;
            }
            if (tempNode.left != null){
                queue.add(tempNode.left);
            }
            if (tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
        return maxValue;
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
        System.out.println(treeSolution(node4));
        assert treeSolution(node4) == 3;
    }
}
