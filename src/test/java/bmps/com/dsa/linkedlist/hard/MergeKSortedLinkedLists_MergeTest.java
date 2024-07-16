package bmps.com.dsa.linkedlist.hard;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedLinkedLists_MergeTest {

    @Test
    void merge() {

        var root1 = new ListNode<>(1);
        root1.next = new ListNode<>(4);
        root1.next.next = new ListNode<>(5);

        var root2 = new ListNode<>(1);
        root2.next = new ListNode<>(3);
        root2.next.next = new ListNode<>(4);


        var root3 = new ListNode<>(2);
        root3.next = new ListNode<>(6);

        MergeKSortedLinkedLists_Merge merge = new MergeKSortedLinkedLists_Merge();

        var res = merge.merge(List.of(root1, root2, root3));
        while(res != null && res.next != null) {
            assertTrue(res.val <= res.next.val, "cur val: " + res.val + " next val: " + res.next.val);
            res = res.next;
        }
    }

    @Test
    void mergeKLists() {
        var root1 = new ListNode<>(1);
        root1.next = new ListNode<>(4);
        root1.next.next = new ListNode<>(5);

        var root2 = new ListNode<>(1);
        root2.next = new ListNode<>(3);
        root2.next.next = new ListNode<>(4);


        var root3 = new ListNode<>(2);
        root3.next = new ListNode<>(6);

        MergeKSortedLinkedLists_Merge merge = new MergeKSortedLinkedLists_Merge();

        ListNode<Integer>[] nodes = new ListNode[] {root1, root2, root3};

        var res = merge.merge(nodes);
        int i = 1;
        while(res != null && res.next != null) {
            assertTrue(res.val <= res.next.val, "cur val: " + res.val + " next val: " + res.next.val);
            res = res.next;
            i++;
        }

        assertEquals( 8, i);
    }
}