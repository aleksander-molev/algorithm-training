package dev.alex.algorithmtraining.problems.week_39_september_2026;

public class Problem01 {
    /*
     * Given an array of positive integers nums and a positive integer target, return the minimal
     * length of a non-empty subarray whose sum is greater than or equal to target. If no such
     * subarray exists, return 0.
     *
     * A subarray is a contiguous sequence of elements in the array.
     *
     * Constraints:
     * - 1 <= target <= 10^9
     * - 1 <= nums.length <= 10^5
     * - 1 <= nums[i] <= 10^4
     *
     * Examples:
     * - target = 7, nums = [2, 3, 1, 2, 4, 3] returns 2.
     * - target = 4, nums = [1, 4, 4] returns 1.
     * - target = 11, nums = [1, 1, 1, 1, 1, 1, 1, 1] returns 0.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;

        for(r = 0; r < nums.length; r++) {
            currSum += nums[r];
            if(currSum >= target) {
                while(currSum >= target) {
                    minLen = Math.min(minLen, r - l + 1);
                    currSum -= nums[l];
                    l++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }
}
