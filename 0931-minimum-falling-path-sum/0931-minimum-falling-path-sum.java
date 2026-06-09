class Solution {

    public int solve(int i, int j, int[][] matrix, Integer[][] dp) {

        int n = matrix.length;

        // Out of bounds
        if (j < 0 || j >= n) {
            return (int)1e9;
        }

        // Last row
        if (i == n - 1) {
            return matrix[i][j];
        }

        // Memoization
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int downLeft = solve(i + 1, j - 1, matrix, dp);

        int down = solve(i + 1, j, matrix, dp);

        int downRight = solve(i + 1, j + 1, matrix, dp);

        return dp[i][j] =
                matrix[i][j]
                + Math.min(downLeft,
                    Math.min(down, downRight));
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        Integer[][] dp = new Integer[n][n];

        int ans = Integer.MAX_VALUE;

        // Start from every column of first row
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans,
                    solve(0, j, matrix, dp));
        }

        return ans;
    }
}