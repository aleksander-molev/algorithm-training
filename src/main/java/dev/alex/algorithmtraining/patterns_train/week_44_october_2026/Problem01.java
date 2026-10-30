package dev.alex.algorithmtraining.patterns_train.week_44_october_2026;

/**
 * Problem:
 * Given an uppercase English string s and a nonnegative integer k, you may
 * replace at most k characters with other uppercase English letters.
 * Find the greatest length of a contiguous substring that can consist of
 * just one repeated letter after these replacements. Return only its length.
 *
 * Examples:
 * s = "ABAB", k = 2 -> 4
 * s = "AABABBA", k = 1 -> 4
 *
 * Constraints:
 * 1 <= s.length() <= 100000
 * s contains only 'A' through 'Z'.
 * 0 <= k <= s.length()
 *
 * Source:
 * LeetCode 424 (paraphrased)
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Difficulty:
 * Medium
 *
 * My pattern:
 * array, counting subsequence
 *
 * My solution:
 * have a Map<Character, Pair<Integer, Integer>> Character, Integer - length, how many k is used or available
 * go through the s elements and for every elements go through the Map's key.
 * for every value if char is the same as key and k left >= than 0 the length++,
 * for every key not the same as current char k--, length++ if k became less than 0, remove pair
 * every time length is update and not remove Math.max for result
 *
 * Instead of map we can use array.
 *
 * Complexity:
 * Time: M(different chars) less than 26 N - so N
 * Space: O(1)
 */
public class Problem01 {
    /**
     * Reference implementation of the revised approach discussed in chat.
     * Each target letter has its own sliding window and replacement budget.
     * Time: O(26 * n) = O(n). Auxiliary space: O(26) = O(1).
     */
    public int characterReplacement(String s, int k) {
        int[] left = new int[26];
        int[] remaining = new int[26];
        java.util.Arrays.fill(remaining, k);
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            int current = s.charAt(right) - 'A';

            for (int target = 0; target < 26; target++) {
                if (current != target) {
                    remaining[target]--;
                }

                // Remove characters until this target's budget is restored.
                while (remaining[target] < 0) {
                    if (s.charAt(left[target]) - 'A' != target) {
                        remaining[target]++;
                    }
                    left[target]++;
                }

                best = Math.max(best, right - left[target] + 1);
            }
        }
        return best;
    }
}
