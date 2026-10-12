package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;

public class Problem03 {
    /*
     * A shop lists item prices in their original order.
     * For each item at index i, find the first index j > i whose original
     * price is less than or equal to prices[i]. That price is the discount:
     * the final price for item i is prices[i] - prices[j].
     * If no such later item exists, its final price stays prices[i].
     * "First" means smallest eligible index, not smallest eligible price.
     * Equality qualifies. Only later items can provide a discount.
     * Each item is processed independently: an item can provide a discount
     * to several earlier items and still receive its own discount.
     * All comparisons and discounts use original prices, not final prices.
     * Return final prices in the original order. Do not modify prices.
     *
     * Constraints:
     * - 0 <= prices.length <= 100000
     * - 1 <= prices[i] <= 1000000000
     *
     * Examples:
     * - [8, 4, 6, 2, 3] returns [4, 2, 4, 2, 3].
     *   Item 0 uses price 4 at index 1: 8 - 4 = 4.
     *   Item 1 uses price 2 at index 3: 4 - 2 = 2.
     *   Item 2 also uses price 2 at index 3: 6 - 2 = 4.
     *   Items 3 and 4 have no eligible later item.
     * - [5, 5, 7] returns [0, 5, 7].
     * - [1, 2, 3] returns [1, 2, 3].
     */
    public int[] finalPrices(int[] prices) {
        Stack<Integer> main = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            int curr = prices[i];

            while (!main.isEmpty() && curr < main.peek()) {
                main.pop();
            }

            if (!main.isEmpty()) {
                curr -= main.peek();
            }

            result[i] = curr;
            main.push(prices[i]);
        }

        return result;
    }
}
