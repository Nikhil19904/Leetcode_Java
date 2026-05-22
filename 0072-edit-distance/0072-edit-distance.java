class Solution {
    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();

        // dp array
        int[][]dp=new int[n][m];

        // initialze with -1;
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        return solve(word1, word2, 0, 0,dp);
    }

    private int solve(String s1,String s2,int i,int j,int[][]dp){

        // if word1 finished
         if(i==s1.length()) {
            return s2.length()-j;
        }


        // if word2 finished
        if(j==s2.length()) {
            return s1.length()-i;
        }

        // characters match
         if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j]=solve(s1, s2, i + 1, j + 1,dp);
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // INSERT
        int insert=1+solve(s1,s2,i,j+1,dp);

        // DELETE
        int delete =1+solve(s1,s2,i+1,j,dp);

        // REPLACE
        int replace=1+solve(s1,s2,i+1,j+1,dp);

        // take minimum
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    
        
    }
}