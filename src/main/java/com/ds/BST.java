package com.ds;

/**
 * Created by prakash.vijay on 07/06/17.
 */
public class BST extends BinaryTree{
    public BST(int rootNodeData) {
        super(rootNodeData);
    }

    public void insert(int dataToInsert) {
        BinaryTree.Node node = root;
        while (true) {
            if (dataToInsert > node.data) {
                if (node.right == null) {
                    node.right = new BinaryTree.Node(dataToInsert);
                    break;
                }
                node = node.right;
            }

            if (dataToInsert < node.data) {
                if (node.left == null) {
                    node.left = new BinaryTree.Node(dataToInsert);
                    break;
                }
                node = node.left;
            }
        }
    }

    public Node convertToDoublyList() {
        convertToDoublyList(root);
        return goLeft(root);
    }

    private void convertToDoublyList(Node node) {
        Node left = node.left;
        Node right = node.right;

        if (left != null) {
            Node predecessor = goRight(left);
            if (predecessor.data < node.data) {
                predecessor.right = node;
                node.left = predecessor;
                convertToDoublyList(left);
            }
        }
        if (right != null) {
            Node successor = goLeft(right);
            if (successor.data > node.data) {
                successor.left = node;
                node.right = successor;
                convertToDoublyList(right);
            }
        }
    }

    public static Node goRight(Node node) {
        if (node.right == null) {
            return node;
        }
        return goRight(node.right);
    }

    public static Node goLeft(Node node) {
        if (node.left == null) {
            return node;
        }
        return goLeft(node.left);
    }
}


