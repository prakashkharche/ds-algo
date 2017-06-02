package com.ds;

/**
 * Created by prakash.vijay on 12/04/17.
 */
public class LinkedList {
    public Node head;

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public LinkedList(int headData) {
        this.head = new Node(headData);
    }

    public int length() {
        return lengthRecursive(head, 0);
    }

    private int lengthRecursive(Node node, int length) {
        if (node == null) {
            return length;
        }
        return lengthRecursive(node.next, ++length);
    }

    public void insertAtStart(int newNodeData) {
        Node newNode = new Node(newNodeData);
        newNode.next = head;
        this.head = newNode;
    }

    public void insertAtMiddle(int insertAfterData, int dataToInsert) {
        Node node = head;
        while (node != null && node.data != insertAfterData) {
            node = node.next;
        }

        if (node == null) {
            System.out.println("Data "+insertAfterData+"  not found in linked list");
            return;
        }
        Node temp = node.next;
        Node newNode = new Node(dataToInsert);
        node.next = newNode;
        newNode.next = temp;
    }

    public void insertAtEnd(int dataToInsert) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        Node newNode = new Node(dataToInsert);
        node.next = newNode;
    }

    public void delete(int dataToDelete) {
        Node previous = null;
        Node current = head;
        while (current != null && current.data != dataToDelete) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data "+dataToDelete+"  not found in linked list");
            return;
        }

        //node to delete is a head
        if (previous == null) {
            head = head.next;
            return;
        }

        previous.next = current.next;
    }

    public void swapNode(int nodeData1, int nodeData2) {
        Node previousNode1 = null;
        Node node1 = null;
        Node previousNode2 = null;
        Node node2 = null;

        Node previous = null;
        Node node = head;

        while (node != null) {
            if (node.data == nodeData1) {
                previousNode1 = previous;
                node1 = node;
            }
            if (node.data == nodeData2) {
                previousNode2 = previous;
                node2 = node;
            }
            previous = node;
            node = node.next;
        }
        if (node1 == null || node2 == null) {
            System.out.println("One of the node not found!!");
            return;
        }

        //node 1 is head
        if (previousNode1 == null) {
            Node temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
            previousNode2.next = node1;
            head = node2;
            return;
        }
        //node 2 is head
        if (previousNode2 == null) {
            Node temp = node2.next;
            node2.next = previousNode1.next;
            node1.next = temp;
            previousNode1.next = node2;
            head = node1;
            return;
        }
        previousNode1.next = node2;
        previousNode2.next = node1;
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }

    public void reverse() {
        Node p = null;
        Node q = head;
        Node r = head.next;

        while (r != null) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        head = q;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.print("null");
    }

    public void printReverse() {
        printReverseRecursive(head);
    }

    private void printReverseRecursive(Node node) {
        if (node == null) {
            return;
        }
        printReverseRecursive(node.next);
        System.out.print(node.data + " --> ");
    }

    public boolean isPalindrome() {
        return false;
    }

    public static LinkedList addNumbers(LinkedList l1, LinkedList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;
        LinkedList sumList = null;
        int carry = 0;
        while (n1 != null || n2 != null) {
            int nodeNumber = 0;
            if (n1 != null && n2 != null) {
                int sum = n1.data + n2.data + carry;
                nodeNumber = sum % 10;
                carry = sum/10;
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1 != null) {
                int sum = n1.data + carry;
                nodeNumber = sum % 10;
                carry = sum/10;
                n1 = n1.next;
            } else {
                int sum = n2.data + carry;
                nodeNumber = sum % 10;
                carry = sum/10;
                n2 = n2.next;
            }
            if (sumList == null) {
                sumList = new LinkedList(nodeNumber);
            } else {
                sumList.insertAtEnd(nodeNumber);
            }
        }

        if (carry != 0) {
            sumList.insertAtEnd(carry);
        }
        return sumList;

    }
}
