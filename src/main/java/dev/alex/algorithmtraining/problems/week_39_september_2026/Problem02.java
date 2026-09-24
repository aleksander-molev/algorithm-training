package dev.alex.algorithmtraining.problems.week_39_september_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem02 {
    /*
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed
     * using letters from magazine, and false otherwise.
     *
     * Each letter in magazine can be used at most once.
     *
     * Constraints:
     * - 1 <= ransomNote.length, magazine.length <= 10^5
     * - ransomNote and magazine consist of lowercase English letters.
     *
     * Examples:
     * - ransomNote = "a", magazine = "b" returns false.
     * - ransomNote = "aa", magazine = "aab" returns true.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> lCounter = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            lCounter.put(magazine.charAt(i),
                    lCounter.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            int chLeft = lCounter.getOrDefault(ransomNote.charAt(i), 0);
            if (chLeft < 1) {
                return false;
            }
            lCounter.put(ransomNote.charAt(i), chLeft - 1);
        }

        return true;
    }
}
