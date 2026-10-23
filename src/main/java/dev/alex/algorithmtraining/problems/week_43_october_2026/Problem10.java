package dev.alex.algorithmtraining.problems.week_43_october_2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem10 {
    /**
     * Return all starting indices in s where a contiguous substring is a
     * rearrangement of p. Include overlapping matches, in ascending index order.
     * Both strings contain only lowercase English letters. Do not modify inputs.
     * Constraints: 0 <= s.length() <= 100000; 1 <= p.length() <= 100000.
     * Examples: s="cbaebabacd", p="abc" -> [0,6];
     * s="abab", p="ab" -> [0,1,2]; s="abcdef", p="gh" -> [].
     */
    public List<Integer> findStarts(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int wSize = p.length();
        Map<Character, Integer> template = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        int pSize = 0;
        for(Character pch : p.toCharArray()) {
            target.put(pch, target.getOrDefault(pch, 0) + 1);
            template.put(pch, template.getOrDefault(pch, 0) + 1);
            pSize++;
        }
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i - left + 1 > wSize) {
                Character chDel = s.charAt(left);
                if(target.containsKey(chDel)) {
                    target.put(chDel, target.get(chDel) + 1);
                    pSize++;
                }
                left++;
            }
            char currCh = s.charAt(i);
            if(target.containsKey(currCh)) {
                int chLeft = target.get(s.charAt(i));
                if(chLeft > 0) {
                    pSize--;
                    chLeft--;
                    target.put(s.charAt(i), chLeft);
                    if (pSize == 0) {
                        result.add(left);
                    }
                } else {
                    while(left < i) {
                        if (s.charAt(left) == currCh) {
                            left++;
                            break;
                        } else {
                            Character chDel = s.charAt(left);
                            if(target.containsKey(chDel)) {
                                target.put(chDel, target.get(chDel) + 1);
                                pSize++;
                            }
                            left++;
                        }
                    }
                }
            } else {
                left = i+1;
                int tmpSize = 0;
                for(Map.Entry<Character, Integer> en: template.entrySet()) {
                    target.put(en.getKey(), en.getValue());
                    tmpSize += en.getValue();
                }
                pSize = tmpSize;
            }
        }

        return result;
    }
}
