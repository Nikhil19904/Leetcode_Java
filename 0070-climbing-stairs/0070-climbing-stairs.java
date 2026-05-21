class Solution {
    public int climbStairs(int n) {
        
    //     // dp array initialization
    //     int[]dp=new int[n+1];
  
    //     // initialize with -1
    //     Arrays.fill(dp,-1);

    //     // start recursion
    //     return solve(n,dp);
    // }

    // private int solve(int n,int[]dp){

    //     if(n==0 || n==1){
    //         return 1;
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    // }

    // dp array
    int[]dp=new int[n+1];

    // base case
    dp[0]=1;
    dp[1]=1;

    // fill table bottom-up
    for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }

    return dp[n];
}
}