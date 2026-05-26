class Solution {
    public int numTrees(int n) {
        return solve(n);
    }

    private int solve(int n){
        // base case
        if(n<=1){
            return 1;
        }

        int ways=0;

        // choose every node as root
        for(int root=1;root<=n;root++){

            int left=solve(root-1);

            int right=solve(n-root);

            ways=ways+left*right;
        }

        return ways;
    }
}
