package bmps.com.dsa.sort;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortLinkedListTest {

    @Test
    void sort() {

        ListNode<Integer> head = new ListNode<>(4);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(1);
        head.next.next.next = new ListNode<>(3);

        MergeSortLinkedList sortLinkedList = new MergeSortLinkedList();

        var sortedNode = sortLinkedList.sort(head);

        assertNotNull(sortedNode);

        while (sortedNode != null && sortedNode.next != null) {
            assertTrue(sortedNode.val < sortedNode.next.val);
            sortedNode = sortedNode.next;
        }
    }
}