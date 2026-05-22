class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n=temperatures.length;

        // final answer arary
        int[]ans=new int[n];

        // stack store indices
        Stack<Integer>stack=new Stack<>();

        // traverse from right to left
        for(int i=n-1;i>=0;i--){
            // remove all smaller or temp
            // bcz they can became answer
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            
            // if stack not empty...top index is warmer day
            if(!stack.isEmpty()){
                ans[i]=stack.peek()-i;
            }
            
            // push current index into stack
            stack.push(i);

        }

        return ans;
        
    }
}