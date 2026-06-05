import java.util.*;

class Solution {

    int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int[][][] dp = new int[group.length][n + 1][minProfit + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, 0, n, minProfit, group, profit, dp);
    }

    private int solve(int i, int members, int prof,
                      int n, int minProfit,
                      int[] group, int[] profit,
                      int[][][] dp) {

        // cap profit
        if (prof > minProfit) {
            prof = minProfit;
        }

        // Base case
        if (i == group.length) {
            return (prof >= minProfit) ? 1 : 0;
        }

        if (dp[i][members][prof] != -1) {
            return dp[i][members][prof];
        }

        // Not pick
        int notPick = solve(i + 1, members, prof, n, minProfit, group, profit, dp);

        // Pick
        int pick = 0;
        if (members + group[i] <= n) {
            pick = solve(i + 1,
                         members + group[i],
                         prof + profit[i],
                         n,
                         minProfit,
                         group,
                         profit,
                         dp);
        }

        return dp[i][members][prof] = (pick + notPick) % MOD;
    }
}