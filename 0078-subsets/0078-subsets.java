class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>>result=new ArrayList<>();

        backtrack(0,nums,new ArrayList<>(),result);

        return result;
        
    }

    private void backtrack(int index,int[]nums,List<Integer>current,List<List<Integer>>result){
        
        // base case
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // choice:1 curr ele ko include kro and next index p move
        current.add(nums[index]);
        backtrack(index+1,nums,current,result);

        // backtrack: jo element add kiya tha usko remove kro
        // taaki baki dusri choice try kar skte
        current.remove(current.size()-1);

        // choice:2 exclude krna curr ele ko
        backtrack(index+1,nums,current,result);
    }
}