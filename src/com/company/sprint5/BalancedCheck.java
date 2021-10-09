package com.company.sprint5;

public class BalancedCheck {
    public static boolean treeSolution(Node head) {
       Result result = isBalancedRecursive(head, -1);
       return result.isBalanced;
    }

    private static Result isBalancedRecursive(Node head, int depth) {
        if (head == null) {
            return new Result(true, -1);
        }

        Result leftSubtreeResult = isBalancedRecursive(head.left, depth + 1);
        Result rightSubtreeResult = isBalancedRecursive(head.right, depth + 1);

        boolean isBalanced = Math.abs(leftSubtreeResult.height - rightSubtreeResult.height) <= 1;
        boolean subtreesAreBalanced = leftSubtreeResult.isBalanced && rightSubtreeResult.isBalanced;
        int height = Math.max(leftSubtreeResult.height, rightSubtreeResult.height) + 1;

        return new Result(isBalanced && subtreesAreBalanced, height);
    }

    private static class Result {
        private final boolean isBalanced;
        private final int height;

        private Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
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
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        System.out.println(treeSolution(node5));
    }
}
