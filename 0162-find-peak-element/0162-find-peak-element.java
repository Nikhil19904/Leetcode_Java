class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean leftGreater =
                    (i == 0) || (nums[i] > nums[i - 1]);

            boolean rightGreater =
                    (i == n - 1) || (nums[i] > nums[i + 1]);

            if (leftGreater && rightGreater) {
                return i;
            }
        }

        return -1;
    }
}