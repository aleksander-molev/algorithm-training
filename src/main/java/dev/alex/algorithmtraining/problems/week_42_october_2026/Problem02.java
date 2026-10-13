package dev.alex.algorithmtraining.problems.week_42_october_2026;

public class Problem02 {
    /*
     * Packages must be shipped in the order given by weights.
     * Choose a positive integer ship capacity, which stays the same every day.
     * Each day you can ship the next consecutive group of remaining packages,
     * provided their total weight does not exceed the capacity.
     * A package cannot be split across days; packages cannot be reordered.
     * There is at most one shipment per day. Finishing earlier is allowed.
     * Return the smallest capacity that ships all packages within days days.
     * Do not modify weights.
     *
     * Constraints:
     * - 1 <= weights.length <= 100000
     * - 1 <= weights[i] <= 10000
     * - 1 <= days <= weights.length
     *
     * Examples:
     * - [1, 2, 3, 4, 5], days = 3 returns 6.
     *   One schedule: [1, 2, 3], [4], [5]. Capacity 5 needs four days.
     * - [3, 2, 2, 4, 1, 4], days = 3 returns 6.
     *   One schedule: [3, 2], [2, 4], [1, 4].
     * - [1, 2, 3], days = 1 returns 6.
     */
    public int shipWithinDays(int[] weights, int days) {

        // days 1 -
        int left = 1;
        int right = 18;

        int ans = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int spend = howManyDays(weights, days, mid);
            if (spend > days) {
                left = mid + 1;
            } else if (spend < days) {
                right = mid - 1;
            } else {
                ans = mid;
                right = mid;
            }
        }
        return ans;
    }

    private int howManyDays(int[] weights, int days, int capacity) {
        int cap = capacity;

        int wI = 0;
        for (int i = 1; i <= days; i++) {
            if (wI >= weights.length) {
                return days - 1;
            }

            while (wI < weights.length && cap - weights[wI] >= 0 ) {
                cap -= weights[wI++];
            }

            if (wI > weights.length) {
                return days - 1;
            }

            cap = capacity;
        }

        return wI < weights.length ? days + 1 : days;
    }
}
