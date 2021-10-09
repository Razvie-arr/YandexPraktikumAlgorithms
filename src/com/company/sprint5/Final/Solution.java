package com.company.sprint5.Final;

import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public static Node remove(Node root, int key) {
        Node removingNode = searchRemovingNode(root, key);
        Node parentOfRemovingNode = searchParentOfNode(root, removingNode);
        if (removingNode.getLeft() == null && removingNode.getRight() == null) {
            simpleNodeDeleting(root, removingNode, parentOfRemovingNode);
        }
        if (removingNode.getLeft() != null && removingNode.getRight() == null) {
            insertRemovingLeftNode(parentOfRemovingNode, removingNode);
            return root;
        } else if (removingNode.getLeft() == null && removingNode.getRight() != null) {
            insertRemovingRightNode(parentOfRemovingNode, removingNode);
            return parentOfRemovingNode;
        }

        Node replacingNode = searchReplacingNode(root.getLeft());
        Node parentOfReplacingNode = searchParentOfNode(root, replacingNode);

        if (replacingNode.getLeft() != null) {
            parentOfReplacingNode.setRight(replacingNode.getLeft());
        } else {
            parentOfReplacingNode.setRight(null);
        }

        if (parentOfRemovingNode.getLeft() == removingNode) {
            parentOfRemovingNode.setLeft(replacingNode);
        } else {
            parentOfRemovingNode.setRight(replacingNode);
        }

        if (removingNode.getLeft() != null) {
            replacingNode.setLeft(removingNode.getLeft());
        }

        if (removingNode.getRight() != null) {
            replacingNode.setRight(removingNode.getRight());
        }
        return parentOfRemovingNode;
    }

    public static void simpleNodeDeleting(Node root, Node removingNode, Node parentOfRemovingNode) {
        if (root == parentOfRemovingNode) {
            if (root.getLeft() == removingNode) {
                root.setLeft(null);
            } else {
                root.setRight(null);
            }
        } else {
            simpleNodeDeleting(root.getLeft(), removingNode, parentOfRemovingNode);
            simpleNodeDeleting(root.getRight(), removingNode, parentOfRemovingNode);
        }
    }

    public static void insertRemovingLeftNode(Node parentNode, Node removingNode) {
        if (parentNode.getRight() == removingNode) {
            parentNode.setRight(removingNode.getLeft());
        } else {
            parentNode.setLeft(removingNode.getLeft());
        }
    }

    public static void insertRemovingRightNode(Node parentNode, Node removingNode) {
        if (parentNode.getRight() == removingNode) {
            parentNode.setRight(removingNode.getRight());
        } else {
            parentNode.setLeft(removingNode.getRight());
        }
    }

    public static Node searchRemovingNode(Node head, int key) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            Node tempNode = queue.poll();
            if (tempNode.getValue() == key) {
                return tempNode;
            }
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return null;
    }

    public static Node searchReplacingNode(Node head) {
        Node replacingNode;
        if (head.getRight() != null) {
            replacingNode = searchReplacingNode(head.getRight());
        } else {
            return head;
        }
        return replacingNode;
    }

    public static Node searchParentOfNode(Node head, Node replacingNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (queue.size() > 0) {
            Node tempNode = queue.poll();
            if (tempNode.getLeft() == replacingNode) {
                return tempNode;
            }
            if (tempNode.getRight() == replacingNode) {
                return tempNode;
            }
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
        return null;
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}