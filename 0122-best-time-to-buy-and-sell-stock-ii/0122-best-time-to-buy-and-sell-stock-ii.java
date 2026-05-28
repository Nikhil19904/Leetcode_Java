class Solution {
    public int maxProfit(int[] prices) {

        int n=prices.length;

        // dp array
        int[][]dp=new int[n][2];

        // initialized with -1
         for(int[] row:dp) {
            Arrays.fill(row,-1);
        }


        return solve(0,1,prices,dp);
        
    }

    private int solve(int i,int buy,int[]prices,int[][]dp){

        // base case
        if(i==prices.length){
            return 0;
        }

        // already computed
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }

        int profit=0;

        // buy state
        if(buy==1){

            int buyStock=-prices[i]+solve(i+1,0,prices,dp);
            int skip=solve(i+1,1,prices,dp);

            profit= Math.max(buyStock,skip);
        }

        // sell state
        else{
            int sellStock=prices[i]+solve(i+1,1,prices,dp);
            int hold=solve(i+1,0,prices,dp);

            profit= Math.max(sellStock,hold);
        }

        return dp[i][buy]=profit;
    }
}