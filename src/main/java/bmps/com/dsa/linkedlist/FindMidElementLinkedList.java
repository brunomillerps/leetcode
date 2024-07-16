package bmps.com.dsa.linkedlist;

public class FindMidElementLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println(searchMid(head));

    }

    private static Node searchMid(Node head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static class Node {
        Node(int val) {
            this.val = val;
        }
        int val;
        Node next;

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}
