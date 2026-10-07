package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem06 {
    /*
     * Given a string s and an integer k, return the length of the longest
     * contiguous substring containing at most k distinct characters.
     *
     * Constraints:
     * - 0 <= s.length() <= 100000
     * - s contains only lowercase English letters
     * - 0 <= k <= 26
     *
     * Examples:
     * - s = "eceba", k = 2 returns 3 ("ece").
     * - s = "aa", k = 1 returns 2.
     * - s = "abaccc", k = 2 returns 4 ("accc").
     */
    public int longestSubstring(String s, int k) {
        if(s.isEmpty()) return 0;
        int max = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            charCount.put(curr, charCount.getOrDefault(curr, 0) + 1);
            int differentChars = charCount.size();

            while(differentChars > k) {
                char removed = s.charAt(left);
                int leftChars = charCount.get(removed) - 1;
                charCount.put(removed, leftChars);
                if(leftChars == 0) {
                    charCount.remove(removed);
                    differentChars = charCount.size();
                }
                left++;
            }

            max = Math.max(right - left + 1, max);
        }

        return max;
    }
}
