package com.ds;

import javafx.util.Pair;

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

    public BinaryTree(Node root) {
        this.root = root;
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

    public static boolean areIdentical(BinaryTree binaryTree1, BinaryTree binaryTree2) {
        return areIdenticalRecursive(binaryTree1.root, binaryTree2.root);
    }

    private static boolean areIdenticalRecursive(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        boolean identicalNode = node1.data == node2.data;
        boolean identicalLeftSubtree = areIdenticalRecursive(node1.left, node2.left);
        boolean identicalRightSubtree = areIdenticalRecursive(node1.right, node2.right);
        return identicalNode && identicalLeftSubtree && identicalRightSubtree;
    }

    public boolean isTreeBalanced() {
        return isTreeBalancedRecursive(root).flag;
    }

    private static IntBool isTreeBalancedRecursive(Node node) {
        if (node == null) {
            return new IntBool(0, true);
        }
        IntBool left = isTreeBalancedRecursive(node.left);
        IntBool right = isTreeBalancedRecursive(node.right);
        if (!left.flag || !right.flag) {
            return new IntBool(Math.max(left.integer, right.integer) + 1, false);
        }
        if (Math.abs(left.integer - right.integer) > 1) {
            return new IntBool(Math.max(left.integer, right.integer) + 1, false);
        }
        return new IntBool(Math.max(left.integer, right.integer) + 1, true);
    }

    public void printAllRootToLeafPaths() {
        printAllRootToLeafPathsRec(root, "");
    }

    private void printAllRootToLeafPathsRec(Node node, String path) {
        if (node.left == null && node.right == null) {
            System.out.println(path + " " + node.data);
            return;
        }

        printAllRootToLeafPathsRec(node.left, path + " " + node.data);
        printAllRootToLeafPathsRec(node.right, path + " " + node.data);
    }

    public void printAncestors(int nodeToSearch) {
        printAncestorsRec(root, "", nodeToSearch);
    }

    private void printAncestorsRec(Node node, String ancestors, int nodeToSearch) {
        if (node == null) {
            return;
        }
        if (node.data == nodeToSearch) {
            System.out.println(ancestors);
            return;
        }

        printAncestorsRec(node.left, ancestors+" "+node.data, nodeToSearch);
        printAncestorsRec(node.right, ancestors+" "+node.data, nodeToSearch);
    }

    public boolean hasSubtree(BinaryTree binaryTree) {
        return hasSubtreeRec(root, binaryTree.root);
    }

    private boolean hasSubtreeRec(Node node1, Node node2) {
        if (node1 == null) {
            return false;
        }
        if (node1.data == node2.data) {
            return isIdentical(node1, node2);
        }
        return hasSubtreeRec(node1.left, node2) || hasSubtreeRec(node1.right, node2) ;
    }

    private boolean isIdentical(Node node1, Node node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        return node1.data == node2.data && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

    public void printSumPaths(int sum) {
        printSumPathsRec(root, sum, 0, "");
    }

    private void printSumPathsRec(Node node, int requiredSum, int sumTillNow, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sumTillNow + node.data == requiredSum) {
                System.out.println(path + " " +node.data);
                return;
            }
            return;
        }
        printSumPathsRec(node.left, requiredSum, sumTillNow+node.data, path+" "+node.data);
        printSumPathsRec(node.right, requiredSum, sumTillNow+node.data, path+" "+node.data);
    }

    public void convertToSumTree() {
        convertToSumTreeRec(root);
    }

    private int convertToSumTreeRec(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            int data = node.data;
            node.data = 0;
            return data;
        }

        int data = node.data;
        node.data = convertToSumTreeRec(node.left) + convertToSumTreeRec(node.right);
        return node.data + data;
    }

    public static BinaryTree construct(int[] preorder, NodeType[] nodeTypes) {
        NodeInt nodeInt = contructRec(preorder, nodeTypes, 0);
        return new BinaryTree(nodeInt.node);
    }

    private static NodeInt contructRec(int[] preorder, NodeType[] nodeTypes, int index) {
        if (index == preorder.length) {
            return null;
        }
        if (nodeTypes[index] == NodeType.L) {
            return new NodeInt(new Node(preorder[index]), ++index);
        }
        Node newNode = new Node(preorder[index]);
        NodeInt left = contructRec(preorder, nodeTypes, ++index);
        newNode.left = left.node;
        NodeInt right = contructRec(preorder, nodeTypes, left.index);
        newNode.right = right.node;
        return new NodeInt(newNode, right.index);
    }

    public static BinaryTree construct(com.ds.LinkedList linkedList) {
        if (linkedList == null || linkedList.length() == 0) {
            return null;
        }
        com.ds.LinkedList.Node lnode = linkedList.head;
        BinaryTree binaryTree = new BinaryTree(linkedList.head.data);
        int index = 0;
        while (lnode != null) {
            com.ds.LinkedList.Node mover = lnode;
            int moves = index + 2;
            while (mover != null) {
                if (moves == 1) {
                    binaryTree.insertInLeft(lnode.data, mover.data);
                }
                if (moves == 0) {
                    binaryTree.insertInRight(lnode.data, mover.data);
                }
                mover = mover.next;
                moves--;
            }
            lnode = lnode.next;
            index++;
        }
        return binaryTree;
    }
}
