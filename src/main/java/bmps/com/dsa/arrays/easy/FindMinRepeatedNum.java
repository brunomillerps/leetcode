package bmps.com.dsa.arrays.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMinRepeatedNum {
    public int minimumRepeated(List<Integer> nums) {
        if (nums.isEmpty()) return 0;

        nums.sort(Integer::compareTo);
        int small_repeated=nums.get(0);
        int acc=0;
        int min_res = Integer.MAX_VALUE;

        for (int i=0, j=1; i < nums.size() && j < nums.size() ; i++,j++) {
            if (nums.get(i).equals(nums.get(j))) {
                acc += 1;
            } else {
                if (acc < min_res) {
                    min_res = acc;
                    small_repeated = nums.get(i);
                } else {
                    small_repeated = nums.get(j);
                }
                acc = 0;
            }
        }

        return small_repeated;
    }

    public int minimumRepeatedCache(List<Integer> nums) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (Integer num : nums) {
            cache.merge(num, 1, Integer::sum);
        }

        int min = Integer.MAX_VALUE;
        int value = 0;
        for (var entry : cache.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                value = entry.getKey();
            }
        }

        return value;
    }

}
