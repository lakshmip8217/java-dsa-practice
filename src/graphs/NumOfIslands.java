package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslands {
    void main() {
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        char[][] grid3 = {
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        char[][] grid4 = {
                {'1', '1'},
                {'1', '1'}
        };
        System.out.println(numIsIsland(grid1));
        System.out.println(numIsIsland(grid2));
        System.out.println(numIsIsland(grid3));
        System.out.println(numIsIsland(grid4));
    }

    /**
     * Time & Space : O(rows × columns)
     * @param grid
     * @return
     */
    public int numIsIsland(char[][] grid) {
        int noOfIslands = 0;
        if(grid.length == 0) {
            return noOfIslands;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        for(int i=0; i< rows; i++) {
            for(int j=0; j< columns; j++) {
                if(grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return noOfIslands;
    }

    public void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        if(r<0 || r>=rows || c<0 || c>=columns || grid[r][c] == '0') {
            return;
        }
        // this is to mark the visited node
        grid[r][c] = '0';
        dfs(grid, r-1, c); //up
        dfs(grid, r+1, c); //dowm
        dfs(grid, r, c-1); //left
        dfs(grid, r, c+1); //right
    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int noOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Check if it's land AND hasn't been visited yet
                if (grid[i][j] == '1' && !visited[i][j]) {
                    noOfIslands++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return noOfIslands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Base cases including the visited check
        if (r < 0 || r >= rows || c < 0 || c >= columns || grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        // Mark the current node as visited instead of altering the grid
        visited[r][c] = true;

        dfs(grid, visited, r - 1, c); // Up
        dfs(grid, visited, r + 1, c); // Down
        dfs(grid, visited, r, c - 1); // Left
        dfs(grid, visited, r, c + 1); // Right
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int noOfIslands = 0;

        // Direction arrays for traveling Up, Down, Left, Right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    noOfIslands++;

                    // Start BFS
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true; // Mark visited immediately upon queueing

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];

                        // Explore 4 neighbors
                        for (int d = 0; d < 4; d++) {
                            int nRow = r + dRow[d];
                            int nCol = c + dCol[d];

                            // Validate bounds, land status, and unvisited status
                            if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < columns
                                    && grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {

                                queue.offer(new int[]{nRow, nCol});
                                visited[nRow][nCol] = true; // Mark visited here to avoid duplicate queuing
                            }
                        }
                    }

                }
            }
        }
        return noOfIslands;
    }
}
