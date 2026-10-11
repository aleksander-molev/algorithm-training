package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.*;

public class Problem09 {
    /*
     * Given two equal-length strings secret and guess containing only digits,
     * return [exact, misplaced].
     * An exact match is the same digit at the same index.
     * After removing all exact matches from both strings, a misplaced match
     * pairs an occurrence of a digit in guess with an occurrence of the same
     * digit in secret. Each occurrence may be used at most once. Return the
     * maximum number of such pairs as misplaced.
     *
     * Constraints:
     * - 0 <= secret.length() == guess.length() <= 100000
     * - Both strings contain only characters '0' through '9'.
     *
     * Examples:
     * - secret = "1807", guess = "7810" returns [1, 3].
     * - secret = "1123", guess = "0111" returns [1, 1].
     * - secret = "1234", guess = "1234" returns [4, 0].
     */
    public int[] countMatches(String secret, String guess) {
        Map<Character, Integer> secrets = new HashMap<>();
        int exact = 0;
        List<Character> nonguessed = new ArrayList<>();
        for(int i = 0; i < secret.length(); i++) {
            char secCh = secret.charAt(i);
            char guesCh = guess.charAt(i);
            if( secCh != guesCh) {
                secrets.put(secCh, secrets.getOrDefault(secCh, 0) + 1);
                nonguessed.add(guesCh);
                continue;
            }
            exact++;
        }

        int misplaced = 0;
        for(char ch: nonguessed) {
            if(secrets.containsKey(ch)) {
                misplaced++;
                int left = secrets.get(ch) - 1;
                secrets.put(ch, left);
                if(left == 0) {
                    secrets.remove(ch);
                }
            }
        }
        return new int[] {exact, misplaced};
    }
}
