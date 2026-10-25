package dev.alex.algorithmtraining.problems.week_43_october_2026;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem11 {
    /**
     * For each price, return the number of consecutive days ending today whose
     * prices are at most today's price. Stop at the first earlier day with a
     * strictly higher price, or at the beginning. Today itself always counts.
     * Return one answer per input day and leave prices unchanged.
     * Constraints: 0 <= prices.length <= 100000; 1 <= prices[i] <= 1000000000.
     * Examples: [100,80,60,70,60,75,85] -> [1,1,1,2,1,4,6];
     * [10,20,30] -> [1,2,3]; [30,20,10] -> [1,1,1].
     */
    public int[] spans(int[] prices) {
        Deque<ValueDays> stack = new ArrayDeque<ValueDays>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            int days = 1;
            while (!stack.isEmpty() && stack.peek().value <= p) {
                var el = stack.pop();
                days += el.days;
                result[el.idx] = el.days;
            }
            stack.push(new ValueDays(p, days, i));
        }

        while (!stack.isEmpty()) {
            result[stack.peek().idx] = stack.pop().days;
        }

        return result;

    }

    class ValueDays {
        int value;
        int days;
        int idx;

        public ValueDays(int value, int days, int idx) {
            this.value = value;
            this.days = days;
            this.idx = idx;
        }
    }
}
