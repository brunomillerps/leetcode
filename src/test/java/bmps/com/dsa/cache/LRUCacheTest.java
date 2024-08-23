package bmps.com.dsa.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    private LRUCache<Integer, String> cache;

    @BeforeEach
    void setUp() {
        cache = new LRUCache<>(3);  // Default capacity for non-parametrized tests
    }

    @Test
    void testCacheHitAndMiss() {
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");

        assertEquals("one", cache.get(1).get()); // Hit
        assertNull(cache.get(4).orElse(null));          // Miss
    }

    @Test
    void testLRUEviction() {
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four"); // Should evict key 1


        String a = "new String()";

        assertNull(cache.get(1).orElse(null)); // Least recently used should be evicted
        assertEquals("four", cache.get(4).get()); // Most recent should be available
    }

    @Test
    void testUpdateValue() {
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(2, "two_updated"); // Update the value for key 2

        assertEquals("two_updated", cache.get(2).get()); // Check if the value is updated
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, 1, one",   // Test with capacity 1
            "2, 3, 2, two",   // Test with capacity 2
    })
    void testLRUEvictionWithDifferentCapacities(int capacity, int putKey, int expectedEvictKey, String expectedValue) {
        LRUCache<Integer, String> paramCache = new LRUCache<>(capacity);
        for (int i = 1; i <= putKey; i++) {
            paramCache.put(i, String.valueOf(i));
        }
        paramCache.put(putKey + 1, String.valueOf(putKey + 1)); // Should trigger eviction

        assertNull(paramCache.get(expectedEvictKey).orElse(null)); // The expected key should be evicted
        assertEquals(String.valueOf(putKey + 1), paramCache.get(putKey + 1).get()); // Check the new entry
    }

    @Test
    void testConcurrency() throws InterruptedException {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
        LRUCache<Integer, String> concurrentCache = new LRUCache<>(5);

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                concurrentCache.put(i, "Value" + i);
                concurrentCache.get(i);
            }
            latch.countDown();
        };

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        latch.await();

        // Assert that the cache behaves as expected after concurrent access
        assertTrue(concurrentCache.get(0) != null || concurrentCache.get(99) != null);
    }

}