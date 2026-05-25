class Solution {
    public int rob(int[] nums) {

        int n=nums.length;

        // dp array
        int[]dp=new int[n+1];

        // initialzied with -1
        Arrays.fill(dp,-1);

        return solve(0,nums,dp);
         
    }

    public int solve(int i, int[]nums,int[]dp){

        // base case
        if(i>=nums.length){
            return 0;
        }

        // already computed
        if(dp[i]!=-1){
            return dp[i];
        }

        // option-1: rob current house
        int rob=nums[i]+solve(i+2,nums,dp);

        // option-2: skip current house
        int skip=solve(i+1,nums,dp);

        return dp[i]=Math.max(rob,skip);
    }
}