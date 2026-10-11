package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem09Test {
    private final Problem09 solution = new Problem09();

    @Test
    void mixedPositions() {
        assertArrayEquals(new int[]{1, 3}, solution.countMatches("1807", "7810"));
    }

    @Test
    void repeatedDigits() {
        assertArrayEquals(new int[]{1, 1}, solution.countMatches("1123", "0111"));
    }

    @Test
    void allExact() {
        assertArrayEquals(new int[]{4, 0}, solution.countMatches("1234", "1234"));
    }

    @Test
    void boundariesAndMaximumLength() {
        assertArrayEquals(new int[]{0, 0}, solution.countMatches("", ""));
        assertArrayEquals(new int[]{1, 0}, solution.countMatches("0", "0"));
        assertArrayEquals(new int[]{0, 0}, solution.countMatches("0", "1"));
        assertArrayEquals(new int[]{0, 0}, solution.countMatches("1111", "2222"));
        assertArrayEquals(new int[]{100000, 0},
                solution.countMatches("1".repeat(100000), "1".repeat(100000)));
        assertArrayEquals(new int[]{0, 100000},
                solution.countMatches("01".repeat(50000), "10".repeat(50000)));
    }

    @Test
    void agreesWithOccurrencePairing() {
        java.util.Random random = new java.util.Random(9);
        for (int trial = 0; trial < 500; trial++) {
            int length = random.nextInt(25);
            StringBuilder secret = new StringBuilder();
            StringBuilder guess = new StringBuilder();
            for (int i = 0; i < length; i++) {
                secret.append(random.nextInt(10));
                guess.append(random.nextInt(10));
            }
            boolean[] usedSecret = new boolean[length];
            boolean[] usedGuess = new boolean[length];
            int exact = 0;
            int misplaced = 0;
            for (int i = 0; i < length; i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    exact++;
                    usedSecret[i] = usedGuess[i] = true;
                }
            }
            for (int i = 0; i < length; i++) {
                if (usedGuess[i]) continue;
                for (int j = 0; j < length; j++) {
                    if (!usedSecret[j] && guess.charAt(i) == secret.charAt(j)) {
                        usedSecret[j] = true;
                        misplaced++;
                        break;
                    }
                }
            }
            assertArrayEquals(new int[]{exact, misplaced},
                    solution.countMatches(secret.toString(), guess.toString()),
                    "secret=" + secret + ", guess=" + guess);
        }
    }
}
