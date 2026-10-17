package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;

public class Problem08 {
    /*
     * Given an integer array sorted in nondecreasing order, retain only
     * values that occur exactly once in the original array.
     * If a value occurs two or more times, remove ALL its occurrences.
     * Modify nums so its first k elements contain the retained values
     * in their original order, and return k. Elements after k do not matter.
     * Perform the operation in place, without another array or collection.
     *
     * Constraints:
     * - 0 <= nums.length <= 100000
     * - -1000000000 <= nums[i] <= 1000000000
     *
     * Examples (only the first k elements are shown):
     * - [1, 1, 2, 3, 3, 4] -> k = 2, prefix [2, 4]
     * - [1, 2, 3] -> k = 3, prefix [1, 2, 3]
     * - [2, 2, 2, 5, 5] -> k = 0, prefix []
     */
    public int retainUnique(int[] nums) {
        int slow = 0;
        int fast = 0;
        int idx = 0;

        for(int n : nums) {
            if(slow == fast) {
                fast++;
                idx++;
                continue;
            }

            if(fast >= nums.length) {
                return idx;
            }

            if(nums[slow] == nums[fast]) {
                while(fast < nums.length && nums[slow] == nums[fast]) {
                    fast++;
                }
                idx = Math.max(0, idx-1);
            }

            if(fast < nums.length && nums[slow] != nums[fast]) {
                nums[idx] = nums[fast];
                slow = fast;
                fast++;
                idx++;
            }

        }
        return idx;
    }
    public int retainUniqueStack(int[] nums) {
        Stack<Count> stack = new Stack<>();
        outerfor:
        for(int n: nums) {
            //[1, 1, 2, 3, 3, 4]
            while(!stack.isEmpty() && stack.peek().val == n) {
                stack.peek().count++;
                continue outerfor;
            }

            while(!stack.isEmpty() && stack.peek().val < n && stack.peek().count > 1) {
                stack.pop();
            }
            stack.push(new Count(n, 1));
        }
        int size = stack.size();
        int res = 0;
        while(!stack.isEmpty()) {
            var cn = stack.pop();
            size--;
            if(cn.count > 1 ) {
                continue;
            }
            nums[size] = cn.val;
            res++;
        }

        return res;
    }

    class Count {
        int val;
        int count;
        public Count(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
