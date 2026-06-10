class Solution {

    int maxi = 0;

    public int maximalSquare(char[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        int[][]dp=new int[n][m];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        solve(0, 0, matrix,dp);

        return maxi * maxi;
    }

    private int solve(int i, int j, char[][] matrix,int [][]dp) {

        if(i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right = solve(i, j + 1, matrix,dp);
        int down = solve(i + 1, j, matrix,dp);
        int diagonal = solve(i + 1, j + 1, matrix,dp);

        int ans = 0;

        if(matrix[i][j] == '1') {

            ans = 1 + Math.min(
                        right,
                        Math.min(down, diagonal)
                  );

            maxi = Math.max(maxi, ans);
        }

        return dp[i][j]=ans;
    }
}