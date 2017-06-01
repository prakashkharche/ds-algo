package com.ds;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prakash.vijay on 12/04/17.
 */
public class LinkedListTest {
    @Before
    public void setUp() throws Exception {


    }

    public LinkedList linkedList() {
        LinkedList linkedList = new LinkedList(5);
        linkedList.insertAtStart(4);
        linkedList.insertAtStart(3);
        linkedList.insertAtStart(2);
        linkedList.insertAtStart(1);
        return linkedList;
    }

    @Test
    public void testInsertAtStart() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.insertAtStart(4);
        linkedList.print();
        assertTrue(linkedList.head.data == 4);
        assertTrue(linkedList.head.next.data == 10);
    }


    @Test
    public void testInsertAtMiddle() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.insertAtMiddle(2, 10);
        linkedList.print();
    }

    @Test
    public void testInsertAtEnd() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.insertAtEnd(10);
        linkedList.print();
    }


    @Test
    public void testDeleteHead() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.delete(1);
        linkedList.print();
    }

    @Test
    public void testDeleteMid() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.delete(3);
        linkedList.print();
    }

    @Test
    public void testDeleteEnd() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.delete(5);
        linkedList.print();
    }


    @Test
    public void testSwap() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.swapNode(1, 4);
        linkedList.print();
    }


    @Test
    public void testReverse() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.reverse();
        linkedList.print();

    }

    @Test
    public void testLength() throws Exception {
        LinkedList linkedList = linkedList();
        System.out.println(linkedList.length());
    }

    @Test
    public void testPrintReverse() throws Exception {
        LinkedList linkedList = linkedList();
        linkedList.printReverse();
    }

    @After
    public void tearDown() throws Exception {


    }
}
