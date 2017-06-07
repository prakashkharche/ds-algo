package com.ds;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by prakash.vijay on 07/06/17.
 */
public class BSTTest {

    BST bst;
    @Before
    public void setUp() throws Exception {
        bst = new BST(50);
        bst.insert(20);
        bst.insert(12);
        bst.insert(35);
        bst.insert(30);
        bst.insert(25);
        bst.insert(6);
        bst.insert(8);
        bst.insert(70);
        bst.insert(80);
        bst.insert(75);
        bst.insert(72);
    }

    @Test
    public void testInorder() throws Exception {
        bst.inorder();
    }

    @Test
    public void testConvertToDoublyList() throws Exception {
        BinaryTree.Node head = bst.convertToDoublyList();
        BinaryTree.Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }

        System.out.println();
        BinaryTree.Node rightMostNode = BST.goRight(head);
        while (rightMostNode != null) {
            System.out.print(rightMostNode.data + " ");
            rightMostNode = rightMostNode.left;
        }
    }
}
