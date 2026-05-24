class Solution {

    int[][][] dp;

    public int maxProfit(int[] prices) {

        int n = prices.length;
        dp = new int[n][2][3]; // cap = 2 → 0..2

        for (int[][] row : dp)
            for (int[] r : row)
                java.util.Arrays.fill(r, -1);

        return solve(0, 1, 2, prices);
    }

    public int solve(int i, int buy, int cap, int[] prices) {

        if (i == prices.length || cap == 0) return 0;

        if (dp[i][buy][cap] != -1) return dp[i][buy][cap];

        int ans;

        if (buy == 1) {

            int take = -prices[i] + solve(i + 1, 0, cap, prices);
            int skip = solve(i + 1, 1, cap, prices);

            ans = Math.max(take, skip);

        } else {

            int sell = prices[i] + solve(i + 1, 1, cap - 1, prices);
            int hold = solve(i + 1, 0, cap, prices);

            ans = Math.max(sell, hold);
        }

        return dp[i][buy][cap] = ans;
    }
}