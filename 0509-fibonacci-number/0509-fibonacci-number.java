class Solution {
    public int fib(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
        
    }

    private int solve(int n,int[]dp){
    //  base case
    if(n==0|| n==1){
        return n;
    }

    // already computed
    if(dp[n]!=-1){
        return dp[n];
    }

    // store and return
    return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }


}