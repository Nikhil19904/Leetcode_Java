class Solution {

    int MOD = 1000000007;

    public int distinctSubseqII(String s) {

        int n = s.length();

        Long[] dp = new Long[n];

        return (int)((solve(s, 0, dp) - 1 + MOD) % MOD);
    }

    private long solve(String s, int index, Long[] dp) {

        // base case
        if (index == s.length()) {
            return 1;
        }

        // already computed
        if (dp[index] != null) {
            return dp[index];
        }

        long ans = 1;

        // track used characters
        HashSet<Character> used = new HashSet<>();

        for (int i = index; i < s.length(); i++) {

            char ch = s.charAt(i);

            // avoid duplicate starting chars
            if (used.contains(ch)) {
                continue;
            }

            used.add(ch);

            ans = (ans + solve(s, i + 1, dp)) % MOD;
        }

        return dp[index] = ans;
    }
}