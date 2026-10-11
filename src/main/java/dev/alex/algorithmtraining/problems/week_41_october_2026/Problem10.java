package dev.alex.algorithmtraining.problems.week_41_october_2026;

public class Problem10 {
    /*
     * You have piles of bananas and h hours to eat all of them.
     * Choose a positive integer eating speed k (bananas per hour).
     * During each hour, choose one pile and eat up to k bananas from it.
     * If that pile contains fewer than k bananas, eat all of it; the rest
     * of that hour cannot be used for another pile.
     * Return the smallest k that lets you finish within h hours.
     * Do not modify piles.
     *
     * Constraints:
     * - 1 <= piles.length <= 100000
     * - 1 <= piles[i] <= 1000000000
     * - piles.length <= h <= 1000000000
     *
     * Examples:
     * - piles = [3, 6, 7, 11], h = 8 returns 4.
     * - piles = [30, 11, 23, 4, 20], h = 5 returns 30.
     * - piles = [30, 11, 23, 4, 20], h = 6 returns 23.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = maxPiles(piles);
        int rK = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canEatAll(h, mid, piles)) {
                hi = mid - 1;
                rK = mid;
            } else {
                lo = mid + 1;
            }
        }

        return rK;
    }

    private boolean canEatAll(int h, int k, int [] piles) {
        for(int pile: piles) {
            int hours = (pile / k) + ((pile % k) == 0 ? 0 : 1);
            h -= hours;
            if(h < 0) {
                return false;
            }
        }

        return true;
    }

    private int maxPiles(int []  piles) {
        int max = 0;
        for(int p: piles) max = Math.max(max, p);
        return max;
    }
}
