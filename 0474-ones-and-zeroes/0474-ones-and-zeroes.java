class Solution {

    int[][][] dp;

    public int findMaxForm(String[] strs, int m, int n) {

        dp = new int[strs.length][m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {

            for (int j = 0; j <= m; j++) {

                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(strs, 0, m, n);
    }

    private int solve(String[] strs, int idx, int m, int n) {

        // base case
        if (idx == strs.length)
            return 0;

        // memoization
        if (dp[idx][m][n] != -1)
            return dp[idx][m][n];

        int zeroes = 0;
        int ones = 0;

        // count zeroes and ones
        for (char ch : strs[idx].toCharArray()) {

            if (ch == '0')
                zeroes++;
            else
                ones++;
        }

        // not take
        int notTake = solve(strs, idx + 1, m, n);

        // take
        int take = 0;

        if (m >= zeroes && n >= ones) {

            take = 1 + solve(
                strs,
                idx + 1,
                m - zeroes,
                n - ones
            );
        }

        return dp[idx][m][n] = Math.max(take, notTake);
    }
}