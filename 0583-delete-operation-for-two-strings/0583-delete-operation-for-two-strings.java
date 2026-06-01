class Solution {
    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();

        // dp array
        int[][]dp=new int[n][m];

        // fill the array
        for(int []row:dp){
            Arrays.fill(row,-1);
        }

        // return solveRec(word1,word2,0,0);
        return solveMemo(word1,word2,0,0,dp);
    }

    private int solveRec(String s1, String s2, int i,int j){

        // word1 khatam
        if(i==s1.length()){
            return s2.length()-j;
        }

        // word2 khatam
        if(j==s2.length()){
            return s1.length()-i;
        }

        // chars match
        if(s1.charAt(i)==s2.charAt(j)){
            return solveRec(s1,s2,i+1,j+1);
        }

        // delete from first string
        int deleteFromS1=1+solveRec(s1,s2,i+1,j);

        // delete from second string
        int deleteFromS2=1+solveRec(s1,s2,i,j+1);

        return Math.min(deleteFromS1,deleteFromS2);
    }

    // memoization
    private int solveMemo(String s1,String s2,int i,int j,int[][]dp){

        // base case
        if(i==s1.length()){
            return s2.length()-j;
        }

        if(j==s2.length()){
            return s1.length()-i;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        
        // chars match
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solveMemo(s1,s2,i+1,j+1,dp);
        }

        
        // delete from first string
        int deleteFromS1=1+solveMemo(s1,s2,i+1,j,dp);

        // delete from second string
        int deleteFromS2=1+solveMemo(s1,s2,i,j+1,dp);


        return dp[i][j]=Math.min(deleteFromS1,deleteFromS2);

    }


}