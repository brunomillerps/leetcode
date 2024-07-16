package bmps.com.dsa.linkedlist.easy;

import bmps.com.dsa.linkedlist.ListNode;

import javax.swing.*;
import java.util.List;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 */
public class ReorderList {
    public void reorderList(ListNode<Integer> head) {
        // 1 -> 2 -> 3 -> 4
        // split the ll in half,
        // invert order 2nd half
        // and merge one each side
        // 1 -> 2
        // 3 -> 4
        // 1, 4, 2, 3
        ListNode<Integer> head2 = findMidNode(head);
        head2 = reverse(head2);
        mergeAlternating(head, head2);
    }

    private ListNode<Integer> findMidNode(ListNode<Integer> head) {
        var slowNode = head;
        var fastNode = head;
        var prev = head;
        while(fastNode != null && fastNode.next != null) {
            prev = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        prev.next = null;
        return slowNode;
    }

    private ListNode<Integer> reverse(ListNode<Integer> head) {
        ListNode<Integer> curNode = head;
        ListNode<Integer> prevNode = null;

        while(curNode != null) {
            var nextTemp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextTemp;
        }

        return prevNode;
    }

    private void mergeAlternating(ListNode<Integer> head, ListNode<Integer> head2) {
        var dummy = new ListNode<Integer>();
        var tail = dummy;

        while (head != null && head2 != null) {
            tail.next = head;
            head = head.next;
            tail.next.next = head2;
            head2 = head2.next;
            tail = tail.next.next;
        }
        if (head != null) {
            tail.next = head;
            tail = tail.next;
        }
        if (head2 != null) {
            tail.next = head2;
            tail = tail.next;
        }
        head = dummy.next;
    }
}
