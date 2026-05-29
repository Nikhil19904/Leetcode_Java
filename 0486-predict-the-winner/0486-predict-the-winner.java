class Solution {
    public boolean predictTheWinner(int[] nums) {

        int diff=solve(nums,0,nums.length-1);

        return diff>=0;
        
    }

    private int solve(int[]nums,int i,int j){

        // base case
        if(i==j){
            return nums[i];
        }

        // take left
        int takeLeft=nums[i]-solve(nums,i+1,j);
        
        // take right
        int takeRight=nums[j]-solve(nums,i,j-1);

        // current player choose best option
        return Math.max(takeLeft,takeRight);
    }
}