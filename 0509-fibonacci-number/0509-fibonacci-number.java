class Solution {
    public int fib(int n) {

        return solve(n);
        
    }

    public int solve(int n){

        // base case
        if(n==0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        int step1=solve(n-1);

        int step2=solve(n-2);

        return step1+step2;
    }
}