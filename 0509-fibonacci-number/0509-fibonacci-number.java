class Solution {
    public int fib(int n) {

        // dp array
        int[]dp=new int[n+1];

        Arrays.fill(dp,-1);

        return solve(n,dp);
    }

    private int solve(int n,int[]dp){

        // base case
        if(n==0) return 0;
        if(n==1) return 1;

        // already computed
        if(dp[n]!=-1){
            return dp[n];
        }

        return solve(n-1,dp)+solve(n-2,dp);
    }
}