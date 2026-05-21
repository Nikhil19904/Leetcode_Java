class Solution {
    public int fib(int n) {

        // base case
        if(n==0 ||n==1){
            return n;
        }

        // dp array
        int[]dp=new int[n+1];

        // initialize base variables
        dp[0]=0;
        dp[1]=1;

        // fill dp table bottom-up
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
        
    }
}