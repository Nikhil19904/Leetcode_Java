class Solution {
    public int lengthOfLIS(int[] nums) {

        int n=nums.length;

        int[][]dp=new int[n][n+1];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,nums,-1,dp);
    }

    private int solve(int i,int nums[],int prevIdx,int[][]dp){

        // base case
        if(i==nums.length){
            return 0;
        }

        // already computed
        if(dp[i][prevIdx+1]!=-1){
            return dp[i][prevIdx+1];
        }

        int notpick=solve(i+1,nums,prevIdx,dp);

        int pick=0;
        if(prevIdx==-1|| nums[i]>nums[prevIdx]){
            pick=1+solve(i+1,nums,i,dp);
        }

        return dp[i][prevIdx+1]=Math.max(pick,notpick);
    }

}