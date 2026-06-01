class Solution {

    public int solve(int i, int j, int[] nums1, int[] nums2,int[][]dp) {

        // base case
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        // already computed
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        // if elements match
        if (nums1[i] == nums2[j]) {
            return dp[i][j]= 1 + solve(i + 1, j + 1, nums1, nums2,dp);
        }

        // if not match → try both possibilities
        int skipNums1 = solve(i + 1, j, nums1, nums2,dp);
        int skipNums2 = solve(i, j + 1, nums1, nums2,dp);

        return dp[i][j]=Math.max(skipNums1, skipNums2);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int n=nums1.length;
        int m=nums2.length;

        int [][]dp =new int[n][m];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0, 0, nums1, nums2,dp);
    }
}