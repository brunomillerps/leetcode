package bmps.com.dsa.trees.trie;

import bmps.com.dsa.linkedlist.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void insert() {

        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.exists("apple"));
        assertFalse(trie.exists("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.exists("app"));

        assertTrue(trie.exists("apple"));
    }
}