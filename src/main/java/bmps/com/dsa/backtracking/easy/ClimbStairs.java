package bmps.com.dsa.backtracking.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ClimbStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);

        return climb(n);
//        return climbRecursion(n, map);
    }

    private int climbRecursion(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);

        int res = climbRecursion(n-2, cache) + climbRecursion(n-1, cache);
        cache.put(n, res);

        return res;
    }

    private int climb(int n) {
        int one = 1, two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one += two;
            two = temp;
        }

        return one;
    }

}
