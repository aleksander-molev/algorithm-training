package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.*;

public class Problem11 {
    /**
     * Return the k most frequent distinct words in words, ordered by decreasing
     * frequency. Equal frequencies are ordered lexicographically ascending
     * (Java String.compareTo). Leave words unchanged.
     * Constraints: 1 <= words.length <= 100000; words contain only lowercase
     * English letters, each length 1..30; 1 <= k <= number of distinct words.
     * Examples: ["i","love","coding","i","love","java"], k=2 -> ["i","love"];
     * ["b","a","c","b","a"], k=3 -> ["a","b","c"];
     * ["red","blue","red","green","blue","red"], k=2 -> ["red","blue"].
     */
    public java.util.List<String> topWords(String[] words, int k) {
        PriorityQueue<SFrequency> pq = new PriorityQueue<>((n1, n2) -> {
            if(n2.freq == n1.freq) {
                return n1.str.compareTo(n2.str);
            }
            return n2.freq - n1.freq;
        });

        Map<String, SFrequency> map = new HashMap<>();


        for(String w: words) {
            var fr = map.getOrDefault(w, new SFrequency(w, 0));
            fr.freq++;
            map.put(w, fr);
        }

        for(String key: map.keySet()) {
            pq.add(map.get(key));
        }

        List<String> res = new ArrayList<>();
        while(k-- > 0 && !pq.isEmpty()) {
            res.add(pq.remove().str);
        }

        return res;
    }

    class SFrequency {
        String str;
        int freq;

        public SFrequency(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }

    }
}
