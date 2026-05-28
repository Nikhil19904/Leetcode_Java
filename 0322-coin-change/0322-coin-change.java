import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int ans = solve(coins, amount, dp);

        return ans >= 1000000000 ? -1 : ans;
    }

    private int solve(int[] coins, int amount, int[] dp) {

        // base cases
        if (amount == 0)
            return 0;

        if (amount < 0)
            return 1000000000;

        // already computed
        if (dp[amount] != -1)
            return dp[amount];

        int minCoins = 1000000000;

        for (int coin : coins) {

            int res = solve(coins, amount - coin, dp);

            minCoins = Math.min(minCoins, 1 + res);
        }

        return dp[amount] = minCoins;
    }
}