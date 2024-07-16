package bmps.com.dsa.dp.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @ParameterizedTest
    @CsvSource({
            "5,8"
    })
    void climbStairs(int n, int res) {

        ClimbingStairs stairs = new ClimbingStairs();

        assertEquals(res, stairs.climbStairs(n));
        assertEquals(res, stairs.climbStairs2(n));
        assertEquals(res, stairs.climStairsLoop(n));
    }
}