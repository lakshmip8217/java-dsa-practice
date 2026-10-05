package dynamic_programming;

public class MinPathSum {

    /**
     * Time - O(m * n)
     * Space - O(1)
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=1; i< rows; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for(int j=1; j< cols; j++) {
            grid[0][j] += grid[0][j-1];
        }

        for(int i=1; i< rows; i++) {
            for (int j=1; j< cols; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[rows-1][cols-1];
    }

    public static void main(String[] args) {

        int[][] testGrid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int result = minPathSum(testGrid);
        System.out.println("Minimum Path Sum: " + result);
        // Should print: Minimum Path Sum: 7
    }
}
