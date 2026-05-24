class Solution {
    int[][]dp;

    // recursion code
    public int solveRec(int i ,int buy, int[]prices){

        // base case
        if(i==prices.length){
            return 0;
        }

        // if can buy the stock
        if(buy==1){

            // option-1: buy the stock
            int Buykaro= -prices[i]+solveRec(i+1,0,prices);

            // option2 : skip the stock
            int SkipKaro=solveRec(i+1,1,prices);

            return Math.max(Buykaro,SkipKaro);
        }

        // if holding stock(must sell or hold)
        else{

            // option-1: sell the stock
            int SellKaro=prices[i]+solveRec(i+1,1,prices);

            // option-2:hold the stock
            int holdKaro=solveRec(i+1,0,prices);

            return Math.max(SellKaro,holdKaro);

        }

    }

    // Memoization code

    public int solveMemo(int i, int buy, int[]prices){

        // base case
        if(i==prices.length){
            return 0;
        }

        // already computed
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }

        int result;

        // if buy the stock
        if(buy==1){

            int BuyKaro=-prices[i] + solveMemo(i + 1, 0, prices);
            int SkipKaro=solveMemo(i + 1, 1, prices);

             result = Math.max(BuyKaro, SkipKaro);
        }

         // If holding stock
        else {

            int SellKaro = prices[i] + solveMemo(i + 1, 1, prices);
            int holdKaro = solveMemo(i + 1, 0, prices);

            result = Math.max(SellKaro, holdKaro);
        }

        return dp[i][buy] = result;
    }

    // tabulation code

    public int solveTab(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        // base case already 0

        for (int i = n - 1; i >= 0; i--) {

            // can buy
            dp[i][1] = Math.max(
                -prices[i] + dp[i + 1][0],
                dp[i + 1][1]
            );

            // holding stock
            dp[i][0] = Math.max(
                prices[i] + dp[i + 1][1],
                dp[i + 1][0]
            );
        }

        return dp[0][1];
    }



    public int maxProfit(int[] prices) {

        int n=prices.length;

        // dp array
        dp= new int[n][2];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        // return solveMemo(0,1,prices);

        return solveTab(prices);

        // return solveRec(0,1,prices);
        
    }
}