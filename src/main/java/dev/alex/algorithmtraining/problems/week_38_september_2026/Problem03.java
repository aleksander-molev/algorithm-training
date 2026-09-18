package dev.alex.algorithmtraining.problems.week_38_september_2026;

import java.util.HashMap;

public class Problem03 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        var chars = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            chars.put(s.charAt(i), chars.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(!chars.containsKey(t.charAt(i))) {
                return false;
            }
            int left = chars.get(t.charAt(i)) - 1;
            if(left == 0) {
                chars.remove(t.charAt(i));
            } else {
                chars.put(t.charAt(i), left);
            }
        }

        return true;
    }
}
