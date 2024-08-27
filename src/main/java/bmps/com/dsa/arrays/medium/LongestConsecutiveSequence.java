package bmps.com.dsa.arrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> deduplicates = new HashSet<>();
        for(int n : nums) deduplicates.add(n);

        int longest = 0;
        for (int n : deduplicates) {
            if (!deduplicates.contains(n-1)) {
                int length = 0;
                while(deduplicates.contains(n + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }


    // 1,2,3,4,5,6,7,8,9,10
}
