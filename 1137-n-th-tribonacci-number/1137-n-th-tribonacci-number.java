class Solution {
    public int tribonacci(int n) {

        // edge cases
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        // dp array
        int[]dp=new int[n+1];

        // bases case
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        // fill bottom
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
        
    }
}