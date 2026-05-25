class Solution {
    int[][] dp;

    public boolean canPartition(int[] nums) {

       int sum = 0;

        // total sum
        for (int x : nums) {
            sum += x;
        }

        // odd sum cannot be divided equally
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int n = nums.length;

        // dp[i][target]
        dp = new int[n][target + 1];

        // initialize with -1
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(0, target, nums);
    }

    public boolean solve(int i,int target, int[]nums){

        // subset found
        if(target==0){
            return true;
        }

        // reached end
        if(i==nums.length){
            return false;
        }

        // already computed
        if(dp[i][target]!=-1){
            return dp[i][target]==1;
        }

        // option-1: not pick
        boolean notPick=solve(i+1,target,nums);

        // option-2: pick
        boolean pick=false;

        if(nums[i]<=target){
            pick=solve(i+1,target-nums[i],nums);
        }

         boolean ans = pick || notPick;

        // store result
        dp[i][target] = ans ? 1 : 0;

        return ans;


    }
}