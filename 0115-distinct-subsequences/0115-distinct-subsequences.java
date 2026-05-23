class Solution {
    public int numDistinct(String s, String t) {

        int n=s.length();
        int m=t.length();

        // dp array
        int[][]dp =new int[n][m];

        // initialize with -1
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        return solve(s, t, 0, 0,dp);
    }

    private int solve(String s, String t,int i,int j,int[][]dp){

        // target formed sucessfully
        if(j==t.length()){
            return 1;
        }

        //target formed sucessfully
        if (i == s.length()) {
            return 0;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];

        }

        //characters match
        if (s.charAt(i) == t.charAt(j)) {

        //take + skip
        return dp[i][j]=solve(s,t,i+1,j+1,dp)
                 + solve(s,t,i+1,j,dp);
        }

        //characters don't match
        return dp[i][j]=solve(s,t,i+1,j,dp);


    }
}