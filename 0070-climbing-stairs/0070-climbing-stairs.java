class Solution {
    public int climbStairs(int n) {

        // dp array
        int []dp = new int[n+1];

        // initialized with -1
        Arrays.fill(dp,-1);

        return solve(0, n,dp);
    }

    public int solve(int i,int n,int[]dp){

        // base case
        if(i==n){
            return 1;
        }

        // crossed top
        if(i>n){
            return 0;
        }

        // already computed
        if(dp[i]!=-1){
            return dp[i];
        }

        // option-1: climd 1 step
        int step1=solve(i+1,n,dp);


        // option-2: climb 2 step
        int step2=solve(i+2,n,dp);

        return dp[i]=step1+step2;
    }
}