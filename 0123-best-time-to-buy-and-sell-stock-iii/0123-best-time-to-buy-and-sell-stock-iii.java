class Solution {

    int[][][] dp;

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // dp[i][buy][cap]
        dp = new int[n][2][3];

        // initialize with -1
        for (int[][] arr:dp) {
            for (int[] row:arr) {
                java.util.Arrays.fill(row,-1);
            }
        }

        return solve(0, 1,2,prices);
    }

    public int solve(int i,int buy,int cap,int[]prices){

        // Base Case
        if(i==prices.length||cap==0) {
            return 0;
        }

        // Already computed
        if(dp[i][buy][cap]!=-1) {
            return dp[i][buy][cap];
        }

        // Can Buy
        if(buy==1){

            // Buy today
            int take=-prices[i]+solve(i+1,0,cap,prices);

            // Skip today
            int skip=solve(i+1,1,cap,prices);

            dp[i][buy][cap]=Math.max(take,skip);
        }

        // Must Sell
        else {

            // Sell today
            int sell = prices[i] + solve(i + 1, 1, cap - 1, prices);

            // Hold stock
            int skip = solve(i + 1, 0, cap, prices);

            dp[i][buy][cap] = Math.max(sell, skip);
        }

        return dp[i][buy][cap];
    }
}