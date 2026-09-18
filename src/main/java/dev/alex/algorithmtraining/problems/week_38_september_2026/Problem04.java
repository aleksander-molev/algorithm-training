package dev.alex.algorithmtraining.problems.week_38_september_2026;

import java.util.HashSet;
import java.util.Set;

public class Problem04 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> met = new HashSet<>();
        int maxsubstr = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if(met.contains(ch)) {
                while(met.contains(ch)) {
                    char delCh = s.charAt(l);
                    met.remove(delCh);
                    l++;
                }
            }
            met.add(ch);
            maxsubstr = Math.max(maxsubstr, r - l + 1);
        }

        return maxsubstr;
    }
}
