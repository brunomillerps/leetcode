package bmps.com.dsa.binarysearch;

public class TwoDimensionArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0, bottom = matrix.length-1;

        while (up <= bottom) {
            int midRow = (up + bottom) / 2;

            if (target >= matrix[midRow][0] && target <= matrix[midRow][matrix[midRow].length-1]) {
                int left = 0, right = matrix[midRow].length-1;

                while(left <= right) {
                    int mid = (left + right) / 2;

                    if (matrix[midRow][mid] == target) return true;

                    if (matrix[midRow][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                return false;

            } else if (matrix[midRow][0] > target) {
                bottom = midRow - 1;
            } else {
                up = midRow + 1;
            }
        }

        return false;
    }
}
