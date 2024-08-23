package bmps.com.dsa.linkedlist;


public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode<String> head) {
        if (head == null || head.next == null) return false;

        return isPalindrome(head, reverse(head));
    }

    private boolean isPalindrome(ListNode<String> head, ListNode<String> head2) {
        while (head != null && head2 != null) {
            if (!head.val.equals(head2.val)) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    ListNode<String> reverse(ListNode<String> head) {
        ListNode<String> curNode = head;
        ListNode<String> prevNode = null;

        while(curNode != null && curNode.val != null) {
            var temp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = temp;
        }

        return prevNode;
    }
}
