class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        // length of both arrays
        int n=nums1.length;
        int m=nums2.length;

        // variable initailze for both arrsys
        int i=0;
        int j=0;

        // traverse both to find common value 
        while(i< n && j<m){
            if(nums1[i]==nums2[j]){
                return nums1[i];

            }

             else if(nums1[i] < nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return -1;

    }
}