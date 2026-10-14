package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;

public class Problem04 {
    /*
     * Given a circular array nums, return an array of the same length.
     * For each index i, move forward through the next indices, wrapping
     * from the last index to index 0. Examine at most nums.length - 1
     * other elements. Return the value of the first element strictly
     * greater than nums[i], or -1 if there is no such element.
     * Equal values do not qualify. "First" means first encountered in
     * this traversal, not the greatest value. Return values, not indices
     * or distances. Do not modify nums. Empty input returns an empty array.
     *
     * Constraints:
     * - 0 <= nums.length <= 100000
     * - -1000000000 <= nums[i] <= 1000000000
     *
     * Examples:
     * - [1, 2, 1] returns [2, -1, 2].
     *   For index 2, visit index 0 (equal, does not qualify), then index 1.
     * - [3, 1, 2] returns [-1, 2, 3].
     * - [2, 2, 3] returns [3, 3, -1].
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Element> stack = new Stack<>();
        int [] res = new int[nums.length];
        int n = nums.length;
        for(int i = 0; i < nums.length * 2; i++) {

            while(!stack.isEmpty() && stack.peek().val < nums[i % n]) {
                var element = stack.peek();
                if(element.val != nums[i % n]) {
                    res[element.idx] = nums[i % n];
                    stack.pop();
                }
            }

            if(i < nums.length) {
                stack.push(new Element(nums[i], i));
            }
        }

        while(!stack.isEmpty()) {
            res[stack.pop().idx] = -1;
        }

        return res;
    }

    class Element {
        int val;
        int idx;

        public Element(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
