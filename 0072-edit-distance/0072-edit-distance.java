class Solution {

    public int minDistance(String word1,
                           String word2) {

        int n=word1.length();
        int m=word2.length();

        // dp array
        int[][]dp = new int[n][m];

        // initialized with -1;
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        return solve(word1, word2, 0, 0,dp);
    }

    private int solve(String s1, String s2,
                      int i, int j,int[][]dp) {

        // word1 finished
        if (i == s1.length()) {
            return s2.length() - j;
        }

        // word2 finished
        if (j == s2.length()) {
            return s1.length() - i;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return solve(s1, s2,
                         i + 1, j + 1,dp);
        }

        // insert
        int insert =
            1 + solve(s1, s2, i, j + 1,dp);

        // delete
        int delete =
            1 + solve(s1, s2, i + 1, j,dp);

        // replace
        int replace =
            1 + solve(s1, s2,
                      i + 1, j + 1,dp);

        return dp[i][j]=Math.min(insert,
               Math.min(delete, replace));
    }
}