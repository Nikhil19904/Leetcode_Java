class Solution {
    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();

        int [][]dp=new int[n][m];

        for(int []row:dp){
            Arrays.fill(row,-1);
        }
         return solve(word1, word2, 0, 0,dp);
    }

    private int solve(String s1, String s2,int i,int j,int[][]dp){

        // s1 exhausted
        if(i==s1.length()){
            return s2.length()-j;
        }

        // s2 exhausted
        if(j==s2.length()){
            return s1.length()-i;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // characters match
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solve(s1,s2,i+1,j+1,dp);
        }

        // delete from s1
        int deleteS1=1+solve(s1,s2,i+1,j,dp);

        // delete from s2
        int deleteS2=1+solve(s1,s2,i,j+1,dp);

        return dp[i][j]=Math.min(deleteS1,deleteS2);
    }
}