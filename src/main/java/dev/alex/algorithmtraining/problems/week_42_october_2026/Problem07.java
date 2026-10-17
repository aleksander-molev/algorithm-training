package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;

public class Problem07 {
    /*
     * Given daily stock prices, return an array span of the same length.
     * span[i] is the maximum number of consecutive days ending at day i
     * (including day i) whose prices are all <= prices[i].
     * Stop counting when a strictly higher price is encountered, or when
     * the beginning of the array is reached. Equal prices qualify.
     * Return answers in the original day order. Do not modify prices.
     *
     * Constraints:
     * - 0 <= prices.length <= 100000
     * - 1 <= prices[i] <= 1000000000
     *
     * Examples:
     * - [100, 80, 60, 70, 60, 75, 85] -> [1, 1, 1, 2, 1, 4, 6]
     *   For price 75, the qualifying days have prices [60, 70, 60, 75].
     *   For price 85, all days after the initial price 100 qualify.
     * - [30, 30, 40] -> [1, 2, 3]
     * - [90, 70, 50] -> [1, 1, 1]
     */
    public int[] calculateSpans(int[] prices) {
        Stack<Pos> stack = new Stack<>();
        int[] span = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            int count = 1;
            while(!stack.isEmpty() && stack.peek().val <= prices[i]) {
                count += stack.pop().count;
            }
            stack.push(new Pos(prices[i], count));
            span[i] = count;
        }

        return span;
    }

    class Pos {
        int val;
        int count;
        public Pos(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
