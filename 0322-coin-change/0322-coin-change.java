class Solution {

    public int coinChange(int[] coins, int amount) {

        int n=coins.length;

        int[][]dp=new int[n][amount+1];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        int ans = solve(0, amount, coins,dp);

        return (ans >= (int)1e9) ? -1 : ans;
    }

    private int solve(int i, int amount, int[] coins,int[][]dp) {

        // Base Case
        if (amount == 0) return 0;

        if (i == coins.length) return (int)1e9;

        // already computed
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        // Not Pick
        int notPick = solve(i + 1, amount, coins,dp);

        // Pick
        int pick = (int)1e9;

        if (coins[i] <= amount) {
            pick = 1 + solve(i, amount - coins[i], coins,dp);
        }

        return dp[i][amount]=Math.min(pick, notPick);
    }
}