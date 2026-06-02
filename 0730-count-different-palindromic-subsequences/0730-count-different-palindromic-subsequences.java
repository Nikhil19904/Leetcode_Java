class Solution {

    long MOD = 1000000007;
    Long[][] dp;

    public int countPalindromicSubsequences(String s) {

        int n = s.length();

        dp = new Long[n][n];

        return (int) solve(s, 0, n - 1);
    }

    private long solve(String s, int i, int j) {

        // Base Cases
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        // Already Computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long ans;

        // Case 1: Characters don't match
        if (s.charAt(i) != s.charAt(j)) {

            ans = solve(s, i + 1, j)
                + solve(s, i, j - 1)
                - solve(s, i + 1, j - 1);
        }
        else {

            int low = i + 1;
            int high = j - 1;

            while (low <= high &&
                   s.charAt(low) != s.charAt(i)) {
                low++;
            }

            while (low <= high &&
                   s.charAt(high) != s.charAt(i)) {
                high--;
            }

            // No same character inside
            if (low > high) {

                ans = 2 * solve(s, i + 1, j - 1) + 2;
            }

            // Exactly one same character inside
            else if (low == high) {

                ans = 2 * solve(s, i + 1, j - 1) + 1;
            }

            // More than one same character inside
            else {

                ans = 2 * solve(s, i + 1, j - 1)
                    - solve(s, low + 1, high - 1);
            }
        }

        ans %= MOD;

        if (ans < 0) {
            ans += MOD;
        }

        return dp[i][j] = ans;
    }
}