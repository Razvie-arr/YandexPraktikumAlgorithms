package com.company.sprint5;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTree {
    public static boolean treeSolution(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(queue.size() > 0){
            Node tempNode = queue.poll();
            if (tempNode.left != null){
                if (tempNode.left.value >= tempNode.value) {
                    return false;
                }
                queue.add(tempNode.left);
            }
            if (tempNode.right != null){
                if (tempNode.right.value <= tempNode.value) {
                    return false;
                }
                queue.add(tempNode.right);
            }
        }
        return true;
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        Node node6 = new Node(9, null, null);
        Node node5 = new Node(6, null, null);
        Node node4 = new Node(3, null, null);
        Node node3 = new Node(1, null, null);
        Node node2 = new Node( 8, node5, node6);
        Node node1 = new Node(3, node3, node4);
        Node node0 = new Node(5, node1, node2);
        System.out.println(treeSolution(node0));
    }
}
