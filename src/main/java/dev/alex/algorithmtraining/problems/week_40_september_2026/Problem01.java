package dev.alex.algorithmtraining.problems.week_40_september_2026;

public class Problem01 {
    /*
     * Given a binary array nums and an integer k, return the maximum number
     * of consecutive 1s obtainable by changing at most k zeros to ones.
     * You only need to return the length; do not modify nums.
     *
     * Constraints:
     * - 1 <= nums.length <= 100000
     * - nums[i] is either 0 or 1.
     * - 0 <= k <= nums.length
     *
     * Examples:
     * - nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], k = 2 returns 6.
     * - nums = [1, 0, 1, 1, 0, 1], k = 1 returns 4.
     */
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            int curr = nums[r];
            if(curr == 1 ) {
                max = Math.max(max, (r - l) + 1);
                continue;
            }

            if(k > 0) {
                k--;
                max = Math.max(max, (r - l) + 1);
                continue;
            }

            while (nums[l++] == 1 && l <= r) {
            }
        }

        return max;
    }
}
