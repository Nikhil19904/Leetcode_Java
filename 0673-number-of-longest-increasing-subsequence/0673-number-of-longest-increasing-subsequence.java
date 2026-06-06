import java.util.*;

class Solution {

    int[][] dpLen;
    int[][] dpCnt;

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        dpLen = new int[n][n + 1];
        dpCnt = new int[n][n + 1];

        for (int[] row : dpCnt) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1).cnt;
    }

    static class Pair {
        int len, cnt;
        Pair(int l, int c) {
            len = l;
            cnt = c;
        }
    }

    private Pair solve(int[] nums, int i, int prev) {

        if (i == nums.length) {
            return new Pair(0, 1);
        }

        if (dpCnt[i][prev + 1] != -1) {
            return new Pair(dpLen[i][prev + 1], dpCnt[i][prev + 1]);
        }

        // not pick
        Pair notPick = solve(nums, i + 1, prev);

        // pick
        Pair pick = new Pair(0, 0);

        if (prev == -1 || nums[i] > nums[prev]) {
            Pair next = solve(nums, i + 1, i);
            pick.len = 1 + next.len;
            pick.cnt = next.cnt;
        }

        Pair res;

        if (pick.len > notPick.len) {
            res = pick;
        } else if (pick.len < notPick.len) {
            res = notPick;
        } else {
            res = new Pair(pick.len, pick.cnt + notPick.cnt);
        }

        dpLen[i][prev + 1] = res.len;
        dpCnt[i][prev + 1] = res.cnt;

        return res;
    }
}