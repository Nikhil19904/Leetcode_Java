class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        return solve(0, 0, nums, target);
    }

    public int solve(int i, int sum, int[] nums, int target) {

        // all elements used
        if (i == nums.length) {

            // valid expression formed
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        // choose +
        int plus = solve(i + 1, sum + nums[i], nums, target);

        // choose -
        int minus = solve(i + 1, sum - nums[i], nums, target);

        return plus + minus;
    }
}