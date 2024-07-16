package bmps.com.dsa.backtracking.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbStairsTest {

    @ParameterizedTest
    @CsvSource({
            "'10,15,20', 15",
            "'1,100,1,1,1,100,1,1,100,1', 6",
    })
    void minCost(String costs, int expect) {
        MinCostClimbStairs minCost = new MinCostClimbStairs();
        var costsInt = Arrays.stream(costs.split(","))
                .mapToInt(Integer::valueOf)
                .boxed().toList();

        var res = minCost.minCost(costsInt);

        Assertions.assertEquals(expect, res);
    }

    @ParameterizedTest
    @CsvSource({
            "'10,15,20', 15",
            "'1,100,1,1,1,100,1,1,100,1', 6",
    })
    void minCostRecursion(String costs, int expect) {
        var costsInt = Arrays.stream(costs.split(","))
                .mapToInt(Integer::valueOf)
                .boxed().toList();

        MinCostClimbStairs minCost = new MinCostClimbStairs();
        var res = minCost.minCostRecursion(costsInt.size(), costsInt);
        assertEquals(expect, res);
    }
}