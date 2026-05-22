class Solution {
    public int minInsertions(String s) {

        String rev=new StringBuilder(s).reverse().toString();

        int n=s.length();

        // dp array
        int[][]dp=new int[n][n];

        // initialize with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // find LPS using LCS
        int lps=solve(s,rev,0,0,dp);

        return n-lps;
        
    }

    private int solve(String s1, String s2, int i,int j,int[][]dp){

        // base case
        if(i==s1.length() || j==s2.length()){
            return 0;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // characters match
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(s1,s2,i+1,j+1,dp);
        }

        // characters don't match
        return dp[i][j]=Math.max(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
    }
}

