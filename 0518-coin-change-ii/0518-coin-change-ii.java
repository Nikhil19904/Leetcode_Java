import java.util.*;

class Solution {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, amount, coins, dp);
    }

    private int solve(int i, int amount, int[] coins, int[][] dp) {

        // Base Case
        if (amount == 0) {
            return 1;
        }

        if (i == coins.length) {
            return 0;
        }

        // Already Computed
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        // Pick (same index because unlimited coins allowed)
        int pick = 0;

        if (coins[i] <= amount) {
            pick = solve(i, amount - coins[i], coins, dp);
        }

        // Not Pick
        int notPick = solve(i + 1, amount, coins, dp);

        return dp[i][amount] = pick + notPick;
    }
}