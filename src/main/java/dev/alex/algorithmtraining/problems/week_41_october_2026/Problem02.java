package dev.alex.algorithmtraining.problems.week_41_october_2026;

public class Problem02 {
    /*
     * Given an integer array nums sorted in non-decreasing order, modify it
     * in place so that each distinct value appears at most twice.
     * Preserve the order of retained elements. Return their count k;
     * nums[0..k) must contain the result. Values after index k - 1 do not matter.
     * Do not allocate another array or collection for the retained elements.
     *
     * Constraints:
     * - 0 <= nums.length <= 100000
     * - -10000 <= nums[i] <= 10000
     *
     * Examples:
     * - [1, 1, 1, 2, 2, 3] returns 5, with prefix [1, 1, 2, 2, 3].
     * - [0, 0, 1, 1, 1, 1, 2, 3, 3] returns 7,
     *   with prefix [0, 0, 1, 1, 2, 3, 3].
     */
    public int removeDuplicates(int[] nums) {

        int l = 0;
        int r = 1;
        if(nums.length < 2) {
            return nums.length == 1 ? 1 : 0;
        }

        int idx = 1;
        int twice = 1;

        while(r < nums.length) {
            while(r < nums.length && nums[l] != nums[r]) {
                nums[idx] = nums[r];
                l = r;
                r++;
                twice = 1;
                idx++;
            }

            while(r < nums.length && nums[l] == nums[r]) {
                if(twice > 0) {
                    nums[idx] = nums[r];
                    twice--;
                    l++;
                    idx++;
                }
                r++;
            }
        }

        return idx;
    }
}
