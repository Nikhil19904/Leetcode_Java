class Solution {
    public int longestPalindromeSubseq(String s) {

        String rev=new StringBuilder(s).reverse().toString();

        int n=s.length();
        int m =rev.length();
    
        // dp array
        int[][]dp=new int[n][m];

        // initialized with -1
        for(int[] row:dp){
           Arrays.fill(row,-1);
        }

        return solve(s,rev,0,0,dp);
        
    }

    private int solve(String s1,String s2,int i,int j,int[][]dp){

        // base case
        if(i==s1.length()||j==s2.length()){
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

        return dp[i][j]=Math.max(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
    }
}