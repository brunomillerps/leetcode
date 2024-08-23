package bmps.com.dsa.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    private final PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

    @ParameterizedTest
    @CsvSource(
            {
                    "level,true",
                    "radar,true",
                    "civic,true",
                    "madam,true",
                    "refer,true",
                    "deified,true",
                    "rotor,true",
                    "repaper,true",
                    "racecar,true",
                    "reviver,true",
                    "bruno,false"
            })
    void testInput(String word, boolean isTrue) {

        ListNode<String> node = stringToLinkList(word);

        assertEquals(isTrue, palindromeLinkedList.isPalindrome(node), word);
    }

    @Test
    void should_reverse_linkedlist() {
        var ll = stringToLinkList("abcd");
        var res = palindromeLinkedList.reverse(ll);
        assertEquals("d", res.val);
    }

    private ListNode<String> stringToLinkList(String word) {
        ListNode<String> dummy = new ListNode<>();
        ListNode<String> tail = dummy;


        // rotor
        for (int i = 0; i < word.length(); i++) {
            tail.val = String.valueOf(word.charAt(i));
            tail.next = new ListNode<>();
            tail = tail.next;
        }

        return dummy;
    }
}