package bmps.com.dsa.linkedlist.hard;

import bmps.com.dsa.linkedlist.ListNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists_Merge {

    public ListNode<Integer> merge(ListNode<Integer>[] lists) {
        if (lists == null || lists.length == 0) return null;

        var result = new ArrayList<ListNode<Integer>>();

        int n = lists.length;
        while(n > 1) {
            var merged = new ArrayList<ListNode<Integer>>();

            for(int i = 0; i < n; i += 2) {
                ListNode<Integer> l1;
                ListNode<Integer> l2;

                if (result.isEmpty()) {
                    l1 = lists[i];
                    l2 = i + 1 < n ? lists[i + 1] : null;
                } else {
                    l1 = result.get(i);
                    l2 = i + 1 < n ? result.get(i + 1) : null;
                }

                merged.add(mergeRecursive(l1, l2));
            }

            result = merged;
            n = result.size();
        }

        return result.get(0);
    }

    private ListNode<Integer> mergeRecursive(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
    }
}
