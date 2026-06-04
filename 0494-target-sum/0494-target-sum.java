class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        return solve(nums, 0, 0, target);
    }

    private int solve(int[] nums, int i, int currentSum, int target) {

        // Base Case
        if (i == nums.length) {

            if (currentSum == target) {
                return 1;
            }

            return 0;
        }

        // Put '+'
        int plus = solve(nums,
                         i + 1,
                         currentSum + nums[i],
                         target);

        // Put '-'
        int minus = solve(nums,
                          i + 1,
                          currentSum - nums[i],
                          target);

        return plus + minus;
    }
}