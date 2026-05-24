class Solution {

    int [][]dp;
        public int maxProfit(int[] prices) {

        int n=prices.length;

        // dp[i][buy]
       dp=new int[n][2];

        // initialize with -1
        for(int[]row:dp){
            java.util.Arrays.fill(row,-1);
        }

        return solve(0, 1, prices);
        
    }

    public int solve(int i, int buy,int[]prices){

        // base case
        if(i==prices.length){
            return 0;
        }

        // If already computed
        if(dp[i][buy]!=-1) {
            return dp[i][buy];
        }


        // can buy
        if(buy==1){

            int take=-prices[i]+solve(i+1,0,prices);
            int skip=solve(i+1,1,prices);
            dp[i][buy]=Math.max(take,skip);
        }

        // Must sell

        else{
            int sell= prices[i]+solve(i+1,1,prices);
            int skip=solve(i+1,0,prices);

            dp[i][buy] =Math.max(sell,skip);
        }

        return dp[i][buy];


    }
} 