class Solution {

    int[][] dp;

    public int maxProfit(int[] prices) {

        int n = prices.length;

        dp = new int[n][2];

        // initialize with -1
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(0, 1, prices);
    }

    public int solve(int i, int buy, int[] prices) {

        // Base Case
        if (i >= prices.length) {
            return 0;
        }

        // Already computed
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        // Can Buy
        if (buy == 1) {

            int buyStock =
                -prices[i] + solve(i + 1, 0, prices);

            int skip =
                solve(i + 1, 1, prices);

            dp[i][buy] = Math.max(buyStock, skip);
        }

        // Must Sell
        else {

            // cooldown => i+2
            int sellStock =
                prices[i] + solve(i + 2, 1, prices);

            int hold =
                solve(i + 1, 0, prices);

            dp[i][buy] = Math.max(sellStock, hold);
        }

        return dp[i][buy];
    }
}