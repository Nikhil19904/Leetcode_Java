class Solution {

    public int minSteps(int n) {
        return solve(n);
    }

    private int solve(int n) {

        // Base Case
        if (n == 1) {
            return 0;
        }

        int ans = n; // worst case

        for (int j = 1; j < n; j++) {

            if (n % j == 0) {

                ans = Math.min(
                    ans,
                    solve(j) + (n / j)
                );
            }
        }

        return ans;
    }
}