class Solution {
    public int countSubstrings(String s) {

        int n=s.length();
        int count=0;

        // dp array
        int[][]dp=new int[n][n];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                if(isPalindrome(s,i,j,dp)){
                    count++;
                }
            }
        }

        return count;
        
    }

    private boolean isPalindrome(String s,int i,int j,int[][]dp){

        // base case
        if(i>=j){
            return true;
        }

        // alraedy computed
        if(dp[i][j]!=-1){
            return dp[i][j]==1;
        }

        // characters don't match
        if(s.charAt(i)!=s.charAt(j)){

            dp[i][j]=0;
            return false;
        }

        // check inner substring
        boolean ans= isPalindrome(s,i+1,j-1,dp);

        dp[i][j]=ans?1:0;

        return ans;
    }
}