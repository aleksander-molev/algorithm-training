package dev.alex.algorithmtraining.problems.week_39_september_2026;

public class Problem03 {
    /*
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
     * For example, [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
     * Given the rotated sorted array nums containing distinct integers, return its minimum element.
     *
     * Constraints:
     * - 1 <= nums.length <= 5 * 10^3
     * - -5 * 10^3 <= nums[i] <= 5 * 10^3
     * - All integers in nums are unique.
     * - nums was originally sorted in ascending order and then rotated.
     *
     * Examples:
     * - nums = [3, 4, 5, 1, 2] returns 1.
     * - nums = [4, 5, 6, 7, 0, 1, 2] returns 0.
     * - nums = [11, 13, 15, 17] returns 11.
     */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int mid = l + (r - l)/2;
            if(nums[l] > nums[r]) {
                l = mid + 1;
            } else if(nums[l] < nums[r]) {
                return nums[l];
            }
        }

        return nums[l];
    }
}
