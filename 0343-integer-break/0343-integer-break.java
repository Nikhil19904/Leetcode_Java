import java.util.*;

class Solution {

    public int integerBreak(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {

        // Base Case
        if (n == 1) {
            return 1;
        }

        // Already Computed
        if (dp[n] != -1) {
            return dp[n];
        }

        int maxProduct = 0;

        for (int i = 1; i < n; i++) {

            int notBreak = i * (n - i);

            int breakFurther = i * solve(n - i, dp);

            maxProduct = Math.max(
                maxProduct,
                Math.max(notBreak, breakFurther)
            );
        }

        return dp[n] = maxProduct;
    }
}