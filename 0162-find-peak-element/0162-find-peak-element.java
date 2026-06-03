class Solution {
    public int findPeakElement(int[] nums) {
        
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            // increasing slope
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }

            // decreasing slope
            else{
                high=mid;
            }
        }
        return low;
    }
}