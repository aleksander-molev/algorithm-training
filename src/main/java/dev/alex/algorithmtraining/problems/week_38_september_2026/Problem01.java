package dev.alex.algorithmtraining.problems.week_38_september_2026;

public class Problem01 {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[]{-1, -1};

        if(nums.length == 1) {
            return nums[0] == target ? new int[]{0,0} : result;
        }

        int lo = 0;
        int hi = nums.length - 1;
        // 1 3 3 3 5 7 9
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                result[0] = mid;
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        lo = 0;
        hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target) {
                result[1] = mid;
                lo = mid + 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }
}
