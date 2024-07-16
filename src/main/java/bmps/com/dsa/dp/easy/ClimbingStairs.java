package bmps.com.dsa.dp.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer n representing the number of steps to reach the top of a staircase.
You can climb with either 1 or 2 steps at a time.

Return the number of distinct ways to climb to the top of the staircase.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();

        var res= rec(0, n, cache);
        return res;
    }

    // start at index 0,
    // increment ith to 1 to represent one step, and ith to 2 for two steps
    // when either 1 or 2 steps equal to N, return 1
    private int rec(int i, int n, Map<Integer, Integer> cache) {
        if (i == n) return 1;
        if (i > n) return 0;

        if (cache.containsKey(i)) return cache.get(i);

        var res = rec(i+1, n, cache) + rec(i+2, n, cache);

        cache.put(i, res);

        return res;
    }

    // start at N
    // warm-up the cache with 1=1 and 2=2
    // decrement 1 for one step and 2 for two steps
    public int climbStairs2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        return rec2(n, cache);
    }

    private int rec2(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);

        var ones = rec2(n-1, cache);
        var twos = rec2(n-2, cache);

        cache.put(n, ones+twos);

        return cache.get(n);
    }

    public int climStairsLoop(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] nums = new int[n];

        nums[0] = 1;
        nums[1] = 2;

        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        return nums[n-1];
    }
}
