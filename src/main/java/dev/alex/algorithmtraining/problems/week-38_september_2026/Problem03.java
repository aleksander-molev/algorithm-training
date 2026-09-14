package dev.alex.algorithmtraining;

public class Problem03 {
    public static void main(String[] args) {
        int[] first = {1, 3, 5, 6};
        System.out.println(searchInsert(first, 5));
        System.out.println(searchInsert(first, 2));
        System.out.println(searchInsert(first, 7));

        first = new int []{1, 3};
        System.out.println(searchInsert(first, 2));

    }

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;

        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
