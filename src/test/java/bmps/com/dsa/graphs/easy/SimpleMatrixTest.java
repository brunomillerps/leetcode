package bmps.com.dsa.graphs.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMatrixTest {

    @Test
    void hasPath() {
        SimpleMatrix matrix = new SimpleMatrix();

        boolean res = matrix.hasPath(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        });
        assertTrue(res);
    }

    @Test
    void has_noPath() {
        SimpleMatrix matrix = new SimpleMatrix();

        boolean res = matrix.hasPath(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0}
        });
        assertFalse(res);
    }
}