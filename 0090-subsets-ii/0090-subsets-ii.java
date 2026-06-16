class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }
    
    private void backtrack(int start, int[] nums ,List<Integer> current, List<List<Integer>> result) {

        // Har point pe current ek valid subset hai
        result.add(new ArrayList<>(current));

        // Explore choices
        for(int i = start; i < nums.length; i++) {
/*
              Duplicate skip condition:

              Agar same level pe same number aa gaya
              to skip karo

              Example:
              [1,2,2]

              second 2 skip hoga
            */

            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }



            // Choice: include nums[i]
            current.add(nums[i]);


            // Next index se continue
            backtrack(i + 1, nums, current, result);



            // Undo choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}