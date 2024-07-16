package bmps.com.dsa.linkedlist.easy;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReorderListTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4', '1,4,2,3'",
            "'1,2,3,4,5', '1,5,2,4,3'",
    })
    void reorderList(String inputNode, String output) {
        ReorderList reorderList = new ReorderList();

        ListNode<Integer> head = toLinkedList(inputNode);
        reorderList.reorderList(head);
        int i = 0;
        var resArray = output.split(",");

        while (head != null) {
            assertTrue(i < resArray.length);
            assertEquals(Integer.parseInt(resArray[i]), head.val);
            head = head.next;
            i++;
        }
    }

    private ListNode<Integer> toLinkedList(String inputNode) {
        var dummy = new ListNode<Integer>();
        var head = dummy;
        for (String node : inputNode.split(",")) {
            head.next = new ListNode<>(Integer.parseInt(node));
            head = head.next;
        }
        return dummy.next;
    }


}