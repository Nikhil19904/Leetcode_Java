import java.util.*;

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    private int solve(int[] nums, int idx, int prevIdx, int[][] dp) {

        if (idx == nums.length) {
            return 0;
        }

        // shift prevIdx by +1
        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        // option 1: skip
        int notTake = solve(nums, idx + 1, prevIdx, dp);

        // option 2: take
        int take = 0;

        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + solve(nums, idx + 1, idx, dp);
        }

        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }
}