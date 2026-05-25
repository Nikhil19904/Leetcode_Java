class Solution {
    public int fib(int n) {

        // dp array
        int[]dp=new int[n+1];

        // initialized with -1
        Arrays.fill(dp,-1);

        return solve(n,dp);
        
    }

    public int solve(int n,int[]dp){

        // base case
        if(n==0){
            return 0;
        }

        // computed already
        if(dp[n]!=-1){
            return dp[n];
        }

        if(n==1){
            return 1;
        }

        int step1=solve(n-1,dp);

        int step2=solve(n-2,dp);

        return dp[n]=step1+step2;
    }
}