import java.util.Arrays;

class Solution {

    public int maxProfit(int[] prices, int fee) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, fee, dp);
    }

    private int solve(int idx, int buy, int[] prices,
                      int fee, int[][] dp) {

        // Base Case
        if (idx == prices.length) {
            return 0;
        }

        // Already computed
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit;

        // Buy State
        if (buy == 1) {

            int buyStock =
                    -prices[idx]
                    + solve(idx + 1, 0, prices, fee, dp);

            int skip =
                    solve(idx + 1, 1, prices, fee, dp);

            profit = Math.max(buyStock, skip);
        }

        // Sell State
        else {

            int sellStock =
                    prices[idx] - fee
                    + solve(idx + 1, 1, prices, fee, dp);

            int hold =
                    solve(idx + 1, 0, prices, fee, dp);

            profit = Math.max(sellStock, hold);
        }

        return dp[idx][buy] = profit;
    }
}