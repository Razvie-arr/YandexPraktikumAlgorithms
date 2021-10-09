package com.company.sprint5.Final;

public class SOFDeletionInBST {
    public static Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }
        //если ключ меньше значения ноды, т.к это BST ищем слева
        else if (key < root.getValue()) {
            root.setLeft(remove(root.getLeft(), key));
        }
        //ищем справа
        else if (key > root.getValue())  {
            root.setRight(remove(root.getRight(), key));
        }
        //нашли узел
        else {
            //кейс 1: у ноды нет потомков, просто делаем ее null
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            }
            //кейс 2: есть потомок только справа, делаем замену удаляемой ноды с ее потомком
            else if (root.getLeft() == null) {
                root = root.getRight();
            }
            //кейс 3: есть потомок только слева, делаем замену удаляемой ноды с ее потомком
            else if (root.getRight() == null) {
                root = root.getLeft();
            }
            //кейс 4: самый сложный, ищем самый правую вершину в левом поддереве
            else {
                int replacingNode = searchReplacingNode(root.getLeft());
                root.setValue(replacingNode);
                root.setLeft(remove(root.getRight(), replacingNode));
            }
        }
        return root;
    }

    public static int searchReplacingNode(Node head) {
        if (head.getRight() == null) {
            return head.getValue();
        }
        return searchReplacingNode(head.getRight());
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
//        гениальное дерево
//        Node node1 = new Node(null, null, 1);
//        Node node2 = new Node(null, null, 3);
//        Node node3 = new Node(null, null, 5);
//        Node node4 = new Node(null, null, 7);
//        Node node5 = new Node(null, null, 9);
//        Node node6 = new Node(null, null, 11);
//        Node node7 = new Node(null, null, 13);
//        Node node8 = new Node(null, null, 15);
//        Node node9 = new Node(node1, node2, 2);
//        Node node10 = new Node(node3, node4, 6);
//        Node node11 = new Node(node5, node6, 10);
//        Node node12 = new Node(node7, node8, 14);
//        Node node13 = new Node(node9, node10, 4);
//        Node node14 = new Node(node11, node12, 12);
//        Node node15 = new Node(node13, node14, 8);
//        Node node1 = new Node(null, null, 2);
//        Node node2 = new Node(node1, null, 3);
//        Node node3 = new Node(null, node2, 1);
//        Node node4 = new Node(null, null, 6);
//        Node node5 = new Node(node4, null, 8);
//        Node node6 = new Node(node5, null, 10);
//        Node node7 = new Node(node3, node6, 5);
//        Node newHead = remove(node7, 10);
//        System.out.println(newHead.getValue() == 5);
//        System.out.println(newHead.getRight() == node5);
//        System.out.println(newHead.getRight().getValue() == 8);

        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        System.out.println(newHead.getValue() == 5);
        System.out.println(newHead.getRight() == node5);
        System.out.println(newHead.getRight().getValue() == 8);
    }
}