package com.ds.linkedlist;

import com.ds.LinkedList;

/**
 * Created by prakash.vijay on 30/08/17.
 */
public class RearrangeLL {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);
        linkedList.insertAtEnd(7);
        linkedList.insertAtEnd(8);
        linkedList.insertAtEnd(9);

        LinkedList.Node mid = mid(linkedList);
        boolean isEven = count(linkedList)%2==0;
        rearrange(mid, linkedList.head, isEven);
        linkedList.print();
    }

    private static LinkedList.Node rearrange(LinkedList.Node node, LinkedList.Node head, boolean isEven) {
        if (node.next == null) {
            LinkedList.Node temp = head.next;
            head.next = node;
            node.next = temp;
            return temp;
        }
        LinkedList.Node source = rearrange(node.next, head, isEven);
        if ((!isEven && source == node) || (isEven && source.next == node)) {
            node.next = null;
            return node;
        }
        LinkedList.Node temp = source.next;
        source.next = node;
        node.next = temp;
        return temp;
    }

    private static LinkedList.Node mid(LinkedList linkedList) {
        LinkedList.Node slow = linkedList.head;
        LinkedList.Node fast = linkedList.head;
        int count = count(linkedList);
        if (count%2 == 0) {
            while (fast != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        } else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }
    private static int count(LinkedList linkedList) {
        int count = 0;
        LinkedList.Node node = linkedList.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
