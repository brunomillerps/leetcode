package bmps.com.dsa.backtracking.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {

    @Test
    void climbStairs() {

        ClimbStairs climbStairs = new ClimbStairs();
        var res = climbStairs.climbStairs(5);

        assertEquals(8, res);
    }
}