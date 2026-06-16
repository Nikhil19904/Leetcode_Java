class Solution {
    public List<List<Integer>> combinationSum(int[] candidate, int target) {
        
          List<List<Integer>> result = new ArrayList<>();
          backtrack(0,candidate,target,new ArrayList<>(),result);
          return result;
    }

    private void backtrack(int start,int[]candidate,int target,List<Integer>current,List<List<Integer>>result){

        if(target==0){
            result.add(new ArrayList(current));
            return ;
        }

        for(int i=start;i<candidate.length;i++){
            if(candidate[i]>target){
                continue;
            }
            // choose
            current.add(candidate[i]);

            backtrack(i,candidate,target-candidate[i],current,result);

            // undo 
            current.remove(current.size()-1);
        }
    }
}