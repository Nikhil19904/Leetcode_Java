class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n=text1.length();
        int m=text2.length();

        // dp array
        int[][]dp=new int[n][m];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        return solveMemo(text1,text2,0,0,dp);
    }

    private int solveMemo(String s1, String s2, int i,int j,int[][]dp){

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
            return dp[i][j]=1 + solveMemo(s1,s2,i+1,j+1,dp);
        }

        // characeters don't match
        return dp[i][j]=Math.max(solveMemo(s1,s2,i+1,j,dp),solveMemo(s1,s2,i,j+1,dp));
    }
}