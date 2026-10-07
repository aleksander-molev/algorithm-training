package dev.alex.algorithmtraining.problems.week_41_october_2026;

public class Problem04 {
    int arrLength = 0;
    int rotationIdx = 0;
    /*
     * nums was strictly increasing before it was rotated by an unknown
     * number of positions (possibly zero). All values are distinct.
     * Return the index of target in nums, or -1 if target is absent.
     * Do not modify nums.
     *
     * Constraints:
     * - 1 <= nums.length <= 100000
     * - -1000000000 <= nums[i], target <= 1000000000
     *
     * Examples:
     * - nums = [4, 5, 6, 7, 0, 1, 2], target = 0 returns 4.
     * - nums = [4, 5, 6, 7, 0, 1, 2], target = 3 returns -1.
     * - nums = [1, 3, 5, 7], target = 5 returns 2.
     */
    public int search(int[] nums, int target) {
        // binary search find a place where array is rotated
        // adjust left, right with - index;
        // left = 0 - has to be 0 + 4
        // 4 -> 4 + 4 > 7?  8 - 7 = 1

        arrLength = nums.length;

        //find rotation point
        int left = 0;
        int right = nums.length - 1;

        while(nums[left] > nums[right]) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        rotationIdx = left;

        left = 0; //idx(0);
        right = nums.length - 1; //idx(nums.length - 1)

        while(left <= right) {
            int mid = left + (right - left) / 2;
// [0, 1, 2, 4, 5, 6, 7 ]
            if(nums[idx(mid)] > target) {
                right = mid - 1;
            } else if (nums[idx(mid)] < target) {
                left = mid + 1;
            } else {
                return idx(mid);
            }
        }

        return -1;
    }



    private int idx(int idx) {
        int r = idx + rotationIdx;
        if(r >= arrLength) {
            return r - arrLength;
        }

        return r;
    }
}
