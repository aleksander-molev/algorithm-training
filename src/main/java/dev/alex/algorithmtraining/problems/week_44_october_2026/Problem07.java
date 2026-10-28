package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.HashSet;
import java.util.Set;

public class Problem07 {
    /**
     * Return the length of the longest contiguous substring containing exactly
     * k distinct characters. Return 0 if no such substring exists.
     * s contains only lowercase English letters; 0 <= s.length() <= 100000;
     * 1 <= k <= 26. Do not modify the input.
     * Examples: ("aabacbebebe", 3) -> 7 ("cbebebe");
     * ("aaabbb", 1) -> 3; ("abcadcacacaca", 3) -> 11 ("cadcacacaca").
     */
    public int longestSegment(String s, int k) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int [] chCounts = new int[26];
        int max = 0;
        int currCount = 0;
        Set<Character> uniques = new HashSet<>();
        int left = 0;

        for(int i = 0; i < s.length(); i++ ) {
            char ch = s.charAt(i);
            uniques.add(ch);
            chCounts[ch - 'a']++;
            currCount++;

            if(uniques.size() <= k) {
                if (uniques.size() == k) {
                    max = Math.max(currCount, max);
                }
            } else {
                while(uniques.size() > k) {
                    char delCh = s.charAt(left);
                    chCounts[delCh - 'a']--;
                    currCount--;
                    left++;
                    if(chCounts[delCh - 'a'] <= 0) {
                        uniques.remove(delCh);
                    }
                }
            }
        }

        return max;
    }
}
