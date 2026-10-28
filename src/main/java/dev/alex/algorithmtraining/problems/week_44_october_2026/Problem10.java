package dev.alex.algorithmtraining.problems.week_44_october_2026;

public class Problem10 {
    /**
     * Given a strictly increasing array of positive integers, return the kth
     * positive integer that does not occur in the array, counting from 1.
     * Do not modify nums.
     * 0 <= nums.length <= 100000; 1 <= nums[i] <= 1000000000;
     * 1 <= k <= 1000000000. The answer fits in int.
     * Examples: ([2,3,4,7,11], 5) -> 9 (missing: 1,5,6,8,9,...);
     * ([1,2,3,4], 2) -> 6; ([1,3,6], 3) -> 5.
     */
    public int kthMissing(int[] nums, int k) {
        int nextExpSeq = 1;
        int missed = 0;
        for(int n : nums) {
            while(n > nextExpSeq) {
                missed++;
                if(missed == k) {
                    return nextExpSeq;
                }
                nextExpSeq++;
            }

            if(n == nextExpSeq) {
                nextExpSeq++;
            }
        }

        while(missed < k) {
            missed++;
            nextExpSeq++;
        }

        return nextExpSeq - 1;
    }
}
