package bmps.com.dsa.graphs.easy;

public class SimpleMatrix {

    public boolean hasPath(int[][] matrix) {
        return hasPathRecursion(matrix, 0, 0);
    }

    private boolean hasPathRecursion(int[][] matrix, int r, int c) {
        if (r >= matrix.length || c >= matrix[0].length) return true;
        if (matrix[r][c] == 1) return false;

        return hasPathRecursion(matrix, r + 1, c) ||
                hasPathRecursion(matrix, r, c + 1);
    }
}
