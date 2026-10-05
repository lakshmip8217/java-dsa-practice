package dynamic_programming;

import java.util.Arrays;

public class MaxSumInGrid {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 4},
                {2, 3}
        };
        System.out.println("Test 1 Result: " + maxSum(grid1)); // Expected: 6
        System.out.println("Test 1 Result: " + maxSumSolution(grid1));

        int[][] grid2 = {
                {3, 2, 9},
                {1, 4, 8},
                {2, 8, 1}
        };
        System.out.println("Test 2 Result: " + maxSum(grid2)); // Expected: 19
        System.out.println("Test 1 Result: " + maxSumSolution(grid2));

        int[][] grid3 = {
                {2, 9, 3, 6},
                {1, 5, 4, 8},
                {8, 3, 2, 1},
                {4, 6, 9, 3}
        };
        System.out.println("Test 3 Result: " + maxSum(grid3)); // Expected: 34
        System.out.println("Test 1 Result: " + maxSumSolution(grid3));
    }

    public static int maxSum(int[][] A) {
        int n = A.length;
        // There are 2^n possible combinations of column states
        int[][] memo = new int[n][1 << n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return placeRooks(A, 0, 0, memo);
    }

    private static int placeRooks(int[][] A, int row, int mask, int[][] memo) {
        // Base Case: All rooks successfully placed
        if (row == A.length) {
            return 0;
        }

        // If we already calculated the max sum for this rook layout, return it
        if (memo[row][mask] != -1) {
            return memo[row][mask];
        }

        int maxVal = Integer.MIN_VALUE;

        // Try placing a rook in every valid column of the current row
        for (int col = 0; col < A[0].length; col++) {
            // Check if the column is NOT under attack
            if ((mask & (1 << col)) == 0) {
                // Place rook, mark column as attacked, and move to the next row
                int currentSum = A[row][col] + placeRooks(A, row + 1, mask | (1 << col), memo);
                maxVal = Math.max(maxVal, currentSum);
            }
        }

        return memo[row][mask] = maxVal;
    }

    public static int maxSumSolution(int[][] A) {
        int max = Integer.MIN_VALUE;
        int rows = A.length;
        int cols = A[0].length;

        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {

                for (int r2 = r1 + 1; r2 < rows; r2++) {
                    for (int c2 = 0; c2 < cols; c2++) {

                        if (c1 != c2) {
                            max = Math.max(
                                    max,
                                    A[r1][c1] + A[r2][c2]
                            );
                        }
                    }
                }
            }
        }
        return max;
    }
}
