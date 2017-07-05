package com.ds;

import static com.ds.NodeType.L;
import static com.ds.NodeType.N;
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

    @Test
    public void testSubtree() throws Exception {
        BinaryTree binaryTree1 = new BinaryTree(2);
        binaryTree1.insertInLeft(2, 4);
        binaryTree1.insertInRight(2, 5);
        assertTrue(binaryTree.hasSubtree(binaryTree1));
    }

    @Test
    public void testPrintSumPaths() throws Exception {
        binaryTree.printSumPaths(7);
    }

    @Test
    public void testConvertToSumTree() throws Exception {
        BinaryTree binaryTree = new BinaryTree(10);
        binaryTree.insertInLeft(10, -2);
        binaryTree.insertInRight(10, 6);
        binaryTree.insertInLeft(-2, 8);
        binaryTree.insertInRight(-2, -4);
        binaryTree.insertInLeft(6, 7);
        binaryTree.insertInRight(6, 5);
        binaryTree.convertToSumTree();
        binaryTree.postOrder();
    }

    @Test
    public void testPreOrderTreeConstruction() throws Exception {
        int[] preorder = {1, 2, 4, 5, 8, 12, 13, 16, 17, 9, 3, 6, 7, 10, 11, 14, 15};
        NodeType[] nodeTypes = {N, N, L, N, N, L, N, L, L, L, N, L, N, L, N, L, L};
        BinaryTree binaryTree = BinaryTree.construct(preorder, nodeTypes);
        binaryTree.preorder();

    }

    @Test
    public void testConstructionFromLL() throws Exception {
        LinkedList l1 = new LinkedList(10);
        l1.insertAtEnd(12);
        l1.insertAtEnd(15);
        l1.insertAtEnd(25);
        l1.insertAtEnd(30);
        l1.insertAtEnd(36);

        BinaryTree binaryTree = BinaryTree.construct(l1);
        binaryTree.preorder();
    }
}
