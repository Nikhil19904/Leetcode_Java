class Solution {
    public int deleteAndEarn(int[] nums) {

    //     // maximum find kro
    //     int max=0;

    //     for (int num : nums) {
    //         max = Math.max(max, num);
    //     }

    //     // points array
    //     // points[i] = total points from value i
    //     int[] points = new int[max + 1];

    //     // total points store karo
    //     for (int num : nums) {
    //         points[num] += num;
    //     }

    //     // recursion start from max value
    //     return solve(points, max);


        
    // }

    // private int solve(int[]points,int i){

    //     // base case
    //     if(i<=0){
    //         return 0;
    //     }

    //     // take current value
    //     int take=points[i]+solve(points,i-2);

    //     // skip current value
    //     int skip=solve(points,i-1);

    //     // return maximum
    //     return Math.max(take,skip);

    // maximum value find karo
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        // points array
        int[] points = new int[max + 1];

        // total points collect karo
        for (int num : nums) {
            points[num] += num;
        }

        // dp array
        int[] dp = new int[max + 1];

        // initialize with -1
        Arrays.fill(dp, -1);

        return solve(points, max, dp);


    }

    private int solve(int[]points,int i,int[]dp){

        // base case
        if(i<=0){
            return 0;
        }

        // already computed
        if(dp[i]!=-1){
            return dp[i];
        }

        // take current
        int take=points[i]+solve(points,i-2,dp);

        // skip current
        int skip=solve(points,i-1,dp);

        // store and return
        return dp[i]=Math.max(take,skip);
    }
}