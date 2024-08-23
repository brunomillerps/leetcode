package bmps.com.dsa.linkedlist;

public class MergeLinkedList {
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        var dummyNode = new ListNode<Integer>();
        var tail = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return dummyNode.next;
    }

    public ListNode<Integer> mergeRecursive(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeRecursive(list1, list2.next);
            return list2;
        }
    }
}


