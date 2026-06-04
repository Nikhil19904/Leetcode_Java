class Solution {

    public int lastStoneWeightII(int[] stones) {

        int totalSum = 0;

        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;
        int n = stones.length;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int bestSubsetSum = solve(stones, 0, target, dp);

        return totalSum - 2 * bestSubsetSum;
    }

    private int solve(int[] stones, int i, int target, int[][] dp) {

        // Base Case
        if (i == stones.length) {
            return 0;
        }

        // Already Computed
        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        // Not Pick
        int notPick = solve(stones, i + 1, target, dp);

        // Pick
        int pick = 0;

        if (stones[i] <= target) {
            pick = stones[i]
                    + solve(stones, i + 1, target - stones[i], dp);
        }

        return dp[i][target] = Math.max(pick, notPick);
    }
}