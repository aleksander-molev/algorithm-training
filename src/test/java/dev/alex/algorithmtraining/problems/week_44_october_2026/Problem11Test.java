package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {
    @Test void example1() {
        assertEquals(java.util.List.of("i", "love"), new Problem11().topWords(new String[]{"i","love","coding","i","love","java"}, 2));
    }
    @Test void example2() {
        assertEquals(java.util.List.of("a", "b", "c"), new Problem11().topWords(new String[]{"b","a","c","b","a"}, 3));
    }
    @Test void example3() {
        assertEquals(java.util.List.of("red", "blue"), new Problem11().topWords(new String[]{"red","blue","red","green","blue","red"}, 2));
    }
    @Test void tiesPrefixesAndRepeatedCalls() {
        verify(new String[]{"a"}, 1);
        verify(new String[]{"aa", "a", "aaa", "aa", "a", "aaa"}, 2);
        String[] words = new String[600];
        for (int i = 0; i < words.length; i++) words[i] = i % 3 == 0 ? "b" : i % 3 == 1 ? "a" : "c";
        verify(words, 2);
    }

    @Test void generatedSortingOracle() {
        java.util.Random random = new java.util.Random(3011);
        String[] vocabulary = {"a", "aa", "ab", "b", "ba", "z", "zzz"};
        for (int trial = 0; trial < 400; trial++) {
            String[] words = new String[1 + random.nextInt(80)];
            for (int i = 0; i < words.length; i++) words[i] = vocabulary[random.nextInt(vocabulary.length)];
            int distinct = new java.util.HashSet<>(java.util.Arrays.asList(words)).size();
            for (int k = 1; k <= distinct; k++) verify(words, k);
        }
    }

    @Test void maximumInput() {
        String[] words = new String[100000];
        for (int i = 0; i < words.length; i++) {
            int value = i;
            StringBuilder word = new StringBuilder("word");
            do {
                word.append((char) ('a' + value % 26));
                value /= 26;
            } while (value > 0);
            words[i] = word.toString();
        }
        verify(words, 1);
        verify(words, words.length);
        java.util.Arrays.fill(words, "same");
        verify(words, 1);
    }

    private void verify(String[] words, int k) {
        String[] original = words.clone();
        java.util.Map<String, Integer> counts = new java.util.HashMap<>();
        for (String word : words) counts.merge(word, 1, Integer::sum);
        java.util.List<String> expected = new java.util.ArrayList<>(counts.keySet());
        expected.sort(java.util.Comparator.<String>comparingInt(counts::get).reversed()
                .thenComparing(java.util.Comparator.naturalOrder()));
        expected = new java.util.ArrayList<>(expected.subList(0, k));
        Problem11 solution = new Problem11();
        assertEquals(expected, solution.topWords(words, k));
        assertEquals(expected, solution.topWords(words, k));
        assertArrayEquals(original, words);
    }
}
