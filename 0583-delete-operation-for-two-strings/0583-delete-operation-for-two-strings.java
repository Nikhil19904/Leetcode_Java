class Solution {

    public int minDistance(String word1,
                           String word2) {

        int n=word1.length();
        int m=word2.length();

        // dp array
        int [][]dp =new int [n][m];

        // initialized with -1
        for(int []row:dp){
           Arrays.fill(row,-1);
        }

        int lcs = solve(word1, word2, 0, 0,dp);

        return (word1.length() - lcs)
             + (word2.length() - lcs);
    }

    private int solve(String s1, String s2,
                      int i, int j,int [][]dp) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j]=1 + solve(s1, s2,
                             i + 1, j + 1,dp);
        }

        return dp[i][j]=Math.max(
            solve(s1, s2, i + 1, j,dp),
            solve(s1, s2, i, j + 1,dp)
        );
    }
}