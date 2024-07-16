package bmps.com.dsa.sort;

import bmps.com.dsa.linkedlist.ListNode;

public class MergeSortLinkedList {
    public ListNode<Integer> sort(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        var middleNode = getMiddleNode(head);
        var nextMiddle = middleNode.next;

        middleNode.next = null;

        var leftSorted = sort(head);
        var rightSorted = sort(nextMiddle);

        return mergeSorted(leftSorted, rightSorted);
    }

    private ListNode<Integer> mergeSorted(ListNode<Integer> leftSorted, ListNode<Integer> rightSorted) {
        if (leftSorted == null) return rightSorted;
        if (rightSorted == null) return  leftSorted;

        ListNode<Integer> head = new ListNode<>();
        var curNode = head;
        while(leftSorted != null && rightSorted != null) {

            if (leftSorted.val <= rightSorted.val) {
                curNode.next = leftSorted;
                leftSorted = leftSorted.next;
            } else {
                curNode.next = rightSorted;
                rightSorted = rightSorted.next;
            }

            curNode = curNode.next;
        }

        while (leftSorted != null) {
            curNode.next = leftSorted;
            leftSorted = leftSorted.next;
        }

        while (rightSorted != null) {
            curNode.next = rightSorted;
            rightSorted = rightSorted.next;
        }

        return head.next;
    }

    private ListNode<Integer> getMiddleNode(ListNode<Integer> head) {
        if (head == null) return null;

        var slow = head;
        var fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
