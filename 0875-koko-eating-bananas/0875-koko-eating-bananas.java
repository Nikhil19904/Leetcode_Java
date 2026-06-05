class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int p : piles) {
            high = Math.max(high, p);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int p : piles) {
                hours += (p + mid - 1) / mid; // ceil
            }

            if (hours <= h) {
                high = mid;   // possible, try smaller
            } else {
                low = mid + 1; // not possible, increase speed
            }
        }

        return low;
    }
}