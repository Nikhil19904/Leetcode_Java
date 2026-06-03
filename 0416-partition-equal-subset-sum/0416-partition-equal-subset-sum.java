class Solution {

    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // Odd sum can't be partitioned equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target, dp);
    }

    private boolean solve(int[] nums,
                          int i,
                          int target,
                          Boolean[][] dp) {

        // Base Case
        if (target == 0) {
            return true;
        }

        if (i == nums.length) {
            return false;
        }

        // Already Computed
        if (dp[i][target] != null) {
            return dp[i][target];
        }

        boolean pick = false;

        if (nums[i] <= target) {
            pick = solve(nums,
                         i + 1,
                         target - nums[i],
                         dp);
        }

        boolean notPick = solve(nums,
                                i + 1,
                                target,
                                dp);

        return dp[i][target] = pick || notPick;
    }
}