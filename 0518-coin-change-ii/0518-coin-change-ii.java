class Solution {

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, amount, coins, dp);
    }

    private int solve(int idx, int amount, int[] coins, int[][] dp) {

        // amount formed
        if (amount == 0)
            return 1;

        // no coins left
        if (idx == coins.length)
            return 0;

        // already computed
        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int notTake = solve(idx + 1, amount, coins, dp);

        int take = 0;

        if (coins[idx] <= amount) {

            // same idx because unlimited supply
            take = solve(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = take + notTake;
    }
}