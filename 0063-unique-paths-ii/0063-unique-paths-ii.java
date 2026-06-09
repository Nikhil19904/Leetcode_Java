class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][]dp=new int[m][n];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,obstacleGrid,dp);
    }

    public int solve(int i,int j,int[][]grid,int [][]dp){
        
        int m=grid.length;
        int n=grid[0].length;

        // base case
        
        // out of bounds
        if(i>=m || j>=n){
            return 0;
        }
        
        // obstacle
        if(grid[i][j]==1){
            return 0;
        }
        
        // destination mil gaya
        if(i==m-1 && j==n-1){
            return 1;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int right=solve(i,j+1,grid,dp);
        int down=solve(i+1,j,grid,dp);
    
        return dp[i][j]=right+down;
    }
}