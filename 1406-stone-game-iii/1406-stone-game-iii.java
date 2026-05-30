class Solution {

    public String stoneGameIII(int[] stoneValue) {

        Integer[] dp = new Integer[stoneValue.length];

        int diff = solve(0, stoneValue, dp);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        }

        return "Tie";
    }

    private int solve(int idx, int[] stoneValue, Integer[] dp) {

        // Base Case
        if (idx >= stoneValue.length) {
            return 0;
        }

        // Already Computed
        if (dp[idx] != null) {
            return dp[idx];
        }

        // Option 1: Take 1 stone
        int option1 =
                stoneValue[idx]
                - solve(idx + 1, stoneValue, dp);

        // Option 2: Take 2 stones
        int option2 = Integer.MIN_VALUE;

        if (idx + 1 < stoneValue.length) {

            option2 =
                    stoneValue[idx]
                    + stoneValue[idx + 1]
                    - solve(idx + 2, stoneValue, dp);
        }

        // Option 3: Take 3 stones
        int option3 = Integer.MIN_VALUE;

        if (idx + 2 < stoneValue.length) {

            option3 =
                    stoneValue[idx]
                    + stoneValue[idx + 1]
                    + stoneValue[idx + 2]
                    - solve(idx + 3, stoneValue, dp);
        }

        return dp[idx] =
                Math.max(option1,
                Math.max(option2, option3));
    }
}