class Solution {

    private int solve(int row,
                      int col1,
                      int col2,
                      int[][] grid,
                      Integer[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (col1 < 0 || col1 >= n ||
            col2 < 0 || col2 >= n) {
            return -(int)1e9;
        }

        // Last row
        if (row == m - 1) {

            if (col1 == col2) {
                return grid[row][col1];
            }

            return grid[row][col1] + grid[row][col2];
        }

        // Memoization
        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }

        int cherries;

        if (col1 == col2) {
            cherries = grid[row][col1];
        } else {
            cherries = grid[row][col1] + grid[row][col2];
        }

        int maxi = -(int)1e9;

        for (int d1 = -1; d1 <= 1; d1++) {

            for (int d2 = -1; d2 <= 1; d2++) {

                maxi = Math.max(
                    maxi,
                    solve(
                        row + 1,
                        col1 + d1,
                        col2 + d2,
                        grid,
                        dp
                    )
                );
            }
        }

        return dp[row][col1][col2] =
                cherries + maxi;
    }

    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Integer[][][] dp =
                new Integer[m][n][n];

        return solve(0, 0, n - 1, grid, dp);
    }
}