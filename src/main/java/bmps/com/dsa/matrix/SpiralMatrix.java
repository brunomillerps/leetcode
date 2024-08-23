package bmps.com.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null ) return null;

        var solution = new ArrayList<Integer>();

        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while(left < right && top < bottom) {

        }

        return solution;
    }
}
