package bmps.com.dsa.linkedlist.hard;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class MergeKSortedLinkedListsHeapTest {

    @Test
    void merge() {
        var root1 = new ListNode<>(1);
        root1.next = new ListNode<>(4);
        root1.next.next = new ListNode<>(5);

        var root2 = new ListNode<>(1);
        root1.next = new ListNode<>(3);
        root1.next.next = new ListNode<>(4);


        var root3 = new ListNode<>(2);
        root1.next = new ListNode<>(6);


        MergeKSortedLinkedLists_Heap merge = new MergeKSortedLinkedLists_Heap();

        merge.merge(List.of(root1, root2, root3));
    }
}