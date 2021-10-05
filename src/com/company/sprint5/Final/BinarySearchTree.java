package com.company.sprint5.Final;

// Java program to demonstrate
// delete operation in binary
// search tree
class BinarySearchTree {
    /* Class containing left
    and right child of current node
    * and key value*/
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

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { root = null; }

    // This method mainly calls deleteRec()
    void deleteKey(int value) { root = deleteRec(root, value); }

    /* A recursive function to
    delete an existing key in BST
    */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.getValue())
            root.setLeft(deleteRec(root.getLeft(), key));
        else if (key > root.getValue())
            root.setRight(deleteRec(root.getRight(), key));

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.setValue(minValue(root.getRight()));

            // Delete the inorder successor
            root.setRight(deleteRec(root.getRight(), root.getValue()));
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.getValue();
        while (root.getLeft() != null)
        {
            minv = root.getLeft().getValue();
            root = root.getLeft();
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
    insert a new value in BST */
    Node insertRec(Node root, int value)
    {

		/* If the tree is empty,
		return a new node */
        if (root == null) {
            return root;
        }

        /* Otherwise, recur down the tree */
        if (value < root.getValue())
            root.setLeft(insertRec(root.getLeft(), value));
        else if (value > root.getValue())
            root.setRight(insertRec(root.getRight(), value));

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getValue() + " ");
            inorderRec(root.getRight());
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

//        Node node1 = new Node(null, null, 2);
//        Node node2 = new Node(node1, null, 3);
//        Node node3 = new Node(null, node2, 1);
//        Node node4 = new Node(null, null, 6);
//        Node node5 = new Node(node4, null, 8);
//        Node node6 = new Node(node5, null, 10);
//        Node node7 = new Node(node3, node6, 5);
//        Node newHead = remove(node7, 10);
        BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
		20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(
                "Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
    }
}
