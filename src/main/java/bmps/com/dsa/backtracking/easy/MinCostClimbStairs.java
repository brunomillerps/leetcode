package bmps.com.dsa.backtracking.easy;

import java.util.List;

public class MinCostClimbStairs {

    public int minCost(List<Integer> costs) {
        int n = costs.size();
        int prev=0, cur=0;

        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur = Math.min(costs.get(i-2) + prev, costs.get(i-1) + cur);
            prev = temp;

        }

        return cur;
    }

    public int minCostDP(List<Integer> costs) {
        int n = costs.size();
        int[] res = new int[n+1];

        for (int i = 2; i <= n; i++) {
            res[i] = Math.min(res[i - 2] + costs.get(i - 2),
                              res[i - 1] + costs.get(i - 1));
        }

        return res[n];
    }

    public int minCostRecursion(int n, List<Integer> costs) {
        if (n <= 1) return 0;

        return Math.min(minCostRecursion(n-1, costs) + costs.get(n-1),
                        minCostRecursion(n-2, costs) + costs.get(n-2));
    }
}
