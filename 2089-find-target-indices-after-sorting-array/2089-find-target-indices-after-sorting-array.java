class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        int start = lowerBound(nums, target);
        int end = upperBound(nums, target) - 1;

        for (int i = start; i <= end; i++) {
            ans.add(i);
        }

        return ans;
    }

    private int lowerBound(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int upperBound(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}