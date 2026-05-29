class Solution {
    public boolean divisorGame(int n) {

        int[] dp=new int[n+1];

        Arrays.fill(dp,-1);

        return solve(n,dp);
        
    }

    private boolean solve(int n,int[]dp){

        // base case
        if(n==1){
            return false;
        }

        // already computed
        if(dp[n]!=-1){
            return dp[n]==1;
        }

        // try all divisors
        for(int x=1;x<n;x++){

            if(n%x==0){

                // opponent loses
                if(!solve(n-x,dp)){

                    dp[n]=1;
                    return true;
                }
            }
        }
        
        dp[n]=0;
        return false;
    }
}