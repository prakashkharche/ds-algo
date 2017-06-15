package com.ds;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by prakash.vijay on 03/06/17.
 */
public class BinaryTreeTest {
    private BinaryTree binaryTree;
    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree(1);
        binaryTree.insertInLeft(1, 2);
        binaryTree.insertInRight(1, 3);
        binaryTree.insertInLeft(2, 4);
        binaryTree.insertInRight(2, 5);
    }

    @Test
    public void testPreOrderTraversal() throws Exception {
        binaryTree.preorder();
    }

    @Test
    public void testSearch() throws Exception {
        int data = 5;
        Optional<BinaryTree.Node> search = binaryTree.search(data);
        assertTrue(search.isPresent());

    }

    @Test
    public void testSearchNotFound() throws Exception {
        int data = 10;
        Optional<BinaryTree.Node> search = binaryTree.search(data);
        assertFalse(search.isPresent());

    }

    @Test
    public void testPostorder() throws Exception {
        binaryTree.postOrder();
    }

    @Test
    public void testInorder() throws Exception {
        binaryTree.inorder();
    }

    @Test
    public void levelOrder() throws Exception {
        binaryTree.levelOrder();
    }

    @Test
    public void testIdentical() throws Exception {
        boolean identical = BinaryTree.areIdentical(binaryTree, binaryTree);
        assertTrue(identical);
    }

    @Test
    public void testNonIdentical() throws Exception {
        BinaryTree binaryTree1 = new BinaryTree(1);
        binaryTree1.insertInLeft(1, 10);
        binaryTree1.insertInRight(1, 3);
        binaryTree1.insertInLeft(2, 4);
        binaryTree1.insertInRight(2, 5);
        boolean identical = BinaryTree.areIdentical(binaryTree, binaryTree);
        assertTrue(identical);
    }

    @Test
    public void isBalancedTree() throws Exception {
        boolean treeBalanced = binaryTree.isTreeBalanced();
        assertTrue(treeBalanced);
    }

    @Test
    public void isUnbalancedTree() throws Exception {
        BinaryTree binaryTree1 = new BinaryTree(1);
        binaryTree1.insertInLeft(1, 10);
        binaryTree1.insertInRight(1, 3);
        binaryTree1.insertInLeft(3, 4);
        binaryTree1.insertInRight(4, 5);
        boolean treeBalanced = binaryTree1.isTreeBalanced();
        assertFalse(treeBalanced);
    }

    @Test
    public void printAllpaths() throws Exception {
        binaryTree.printAllRootToLeafPaths();
    }

    @Test
    public void printAncestors() throws Exception {
        binaryTree.printAncestors(4);
    }
}
