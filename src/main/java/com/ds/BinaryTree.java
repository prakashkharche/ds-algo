package com.ds;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by prakash.vijay on 03/06/17.
 */
public class BinaryTree {
    public Node root;
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public BinaryTree(int rootNodeData) {
        this.root = new Node(rootNodeData);
    }

    public boolean insertInLeft(int existingNodeData, int newNodeData) {
        Optional<Node> existingNodeOptional = search(existingNodeData);
        if (!existingNodeOptional.isPresent()) {
            return false;
        }
        Node existingNode = existingNodeOptional.get();
        if (existingNode.left != null) {
            return false;
        }
        existingNodeOptional.get().left = new Node(newNodeData);
        return true;
    }

    public boolean insertInRight(int existingNodeData, int newNodeData) {
        Optional<Node> existingNodeOptional = search(existingNodeData);
        if (!existingNodeOptional.isPresent()) {
            return false;
        }
        Node existingNode = existingNodeOptional.get();
        if (existingNode.right != null) {
            return false;
        }
        existingNodeOptional.get().right = new Node(newNodeData);
        return true;
    }

    public Optional<Node> search(int nodeData) {
        return searchRecursion(root, nodeData);
    }

    private static Optional<Node> searchRecursion(Node node, int data) {
        if (node == null) {
            return Optional.empty();
        }
        if (node.data == data) {
            return Optional.of(node);
        }
        Optional<Node> leftOptional = searchRecursion(node.left, data);
        if (leftOptional.isPresent()) {
            return leftOptional;
        }
        Optional<Node> rightOptional = searchRecursion(node.right, data);
        if (rightOptional.isPresent()) {
            return rightOptional;
        }
        return Optional.empty();
    }

    public void preorder() {
        preorderRecursion(root);
    }

    private static void preorderRecursion(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderRecursion(node.left);
        preorderRecursion(node.right);
    }

    public void postOrder() {
        postOrderRecursion(root);
    }

    private static void postOrderRecursion(Node node) {
        if (node == null) {
            return;
        }

        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(node.data + " ");
    }

    public void inorder() {
        inorderRecursion(root);
    }

    private static void inorderRecursion(Node node) {
        if (node == null) {
            return;
        }

        inorderRecursion(node.left);
        System.out.print(node.data + " ");
        inorderRecursion(node.right);
    }

    public void levelOrder() {
        Queue<Node> levels = new LinkedList<>();
        levels.add(root);
        while (!levels.isEmpty()) {
            Node node = levels.poll();
            if (node.left != null) {
                levels.add(node.left);
            }
            if (node.right != null) {
                levels.add(node.right);
            }
            System.out.print(node.data + " ");
        }
    }

}
