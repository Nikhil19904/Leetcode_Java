import java.util.*;

class Solution {

    public int minSteps(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {

        // Base Case
        if (n == 1) {
            return 0;
        }

        // Already Computed
        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = n; // worst case

        for (int j = 1; j < n; j++) {

            if (n % j == 0) {

                ans = Math.min(
                    ans,
                    solve(j, dp) + (n / j)
                );
            }
        }

        return dp[n] = ans;
    }
}