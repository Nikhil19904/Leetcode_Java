class Solution {

    public boolean stoneGame(int[] piles) {

        int n = piles.length;

        Integer[][] dp =
                new Integer[n][n];

        int diff =
            solve(piles,0,n-1,dp);

        return diff > 0;
    }

    private int solve(int[] piles,
                      int i,
                      int j,
                      Integer[][] dp){

        if(i==j){
            return piles[i];
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        int left =
            piles[i] -
            solve(piles,i+1,j,dp);

        int right =
            piles[j] -
            solve(piles,i,j-1,dp);

        return dp[i][j] =
               Math.max(left,right);
    }
}