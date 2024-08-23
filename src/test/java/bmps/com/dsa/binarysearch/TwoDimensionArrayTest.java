package bmps.com.dsa.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionArrayTest {

    @ParameterizedTest
    @CsvSource({
            "'[[1,3,5,7],[10,11,16,20],[23,30,34,60]]', 3, true",
            "'[[1,3,5,7],[10,11,16,20],[23,30,34,60]]', 13, false"
    })
    void searchMatrix(String arrString, int target, boolean expected) {
        TwoDimensionArray twoD = new TwoDimensionArray();
        int[][] arr = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        var res = twoD.searchMatrix(arr, target);
        Assertions.assertEquals(expected, res);
    }

    @Test
    void testLruCache() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>(1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };

        a.put("1", "1");
        a.put("2", "2");
        a.put("3", "3");
        a.put("1", "1.1");

        assertEquals(3, a.size());

        assertTrue(a.values().containsAll(List.of("2", "3", "1.1")));
        assertFalse(a.containsValue("1"));
    }

    @Test
    void testLruCache_lru() {
        LinkedHashMap<String, String> a = new LinkedHashMap<>(1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;
            }
        };

        a.put("1", "1");
        a.put("2", "2");
        a.put("3", "3");
        a.get("1");
        a.put("4", "4");

        assertEquals(3, a.size());

        assertTrue(a.values().containsAll(List.of("1", "3", "4")));
        assertFalse(a.containsValue("2"));

    }
}