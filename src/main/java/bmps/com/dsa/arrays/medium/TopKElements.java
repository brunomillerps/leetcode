package bmps.com.dsa.arrays.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for(int n : nums) {
            counts.merge(n, 1, Integer::sum);
        }

        var heap = new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        heap.addAll(counts.entrySet());

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }

        return res;
    }

}
