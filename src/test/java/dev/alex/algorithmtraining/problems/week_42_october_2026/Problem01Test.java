package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem01Test {
    @Test
    void matchesDirectCollisionSimulation() {
        java.util.Random random = new java.util.Random(42);
        Problem01 solution = new Problem01();
        for (int trial = 0; trial < 1000; trial++) {
            int[] input = new int[random.nextInt(15)];
            java.util.List<Integer> remaining = new java.util.ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                int size = 1 + random.nextInt(10);
                input[i] = random.nextBoolean() ? size : -size;
                remaining.add(input[i]);
            }
            int[] original = input.clone();
            boolean changed;
            do {
                changed = false;
                for (int i = 0; i + 1 < remaining.size(); i++) {
                    int left = remaining.get(i);
                    int right = remaining.get(i + 1);
                    if (left > 0 && right < 0) {
                        if (left == -right) {
                            remaining.remove(i + 1);
                            remaining.remove(i);
                        } else if (left > -right) {
                            remaining.remove(i + 1);
                        } else {
                            remaining.remove(i);
                        }
                        changed = true;
                        break;
                    }
                }
            } while (changed);
            int[] expected = remaining.stream().mapToInt(Integer::intValue).toArray();
            assertArrayEquals(expected, solution.asteroidCollision(input),
                    java.util.Arrays.toString(input));
            assertArrayEquals(original, input);
        }
    }

    @Test
    void handlesBoundarySizesAndLongCollisionChains() {
        Problem01 solution = new Problem01();
        assertArrayEquals(new int[]{}, solution.asteroidCollision(new int[]{}));
        assertArrayEquals(new int[]{-1000000000},
                solution.asteroidCollision(new int[]{-1000000000}));
        assertArrayEquals(new int[]{},
                solution.asteroidCollision(new int[]{1000000000, -1000000000}));
        int[] input = new int[100000];
        java.util.Arrays.fill(input, 1);
        input[input.length - 1] = -1000000000;
        int[] original = input.clone();
        assertArrayEquals(new int[]{-1000000000}, solution.asteroidCollision(input));
        assertArrayEquals(original, input);
        java.util.Arrays.fill(input, -1);
        assertArrayEquals(input, solution.asteroidCollision(input));
    }

    @Test
    void handlesMultipleAsteroidsMovingLeft() {
        assertArrayEquals(new int[]{-20},
                new Problem01().asteroidCollision(new int[]{5, 10, -5, -20}));
    }

    @Test
    void preservesAsteroidsMovingApart() {
        assertArrayEquals(new int[]{-2, 1},
                new Problem01().asteroidCollision(new int[]{-2, 1}));
    }

    @Test
    void continuesThroughEarlierSurvivors() {
        assertArrayEquals(new int[]{-10},
                new Problem01().asteroidCollision(new int[]{3, 5, 2, -10}));
    }

    @Test
    void myTest() {
        assertArrayEquals(new int[]{-1, -2, 5, 10},
                new Problem01().asteroidCollision(new int[]{-1, -2, 5, 10, -5 }));
    }

    @Test
    void largerAsteroidSurvives() {
        assertArrayEquals(new int[]{5, 10},
                new Problem01().asteroidCollision(new int[]{5, 10, -5}));
    }

    @Test
    void equalSizesDestroyEachOther() {
        assertArrayEquals(new int[]{},
                new Problem01().asteroidCollision(new int[]{8, -8}));
    }

    @Test
    void resolvesSuccessiveCollisions() {
        assertArrayEquals(new int[]{10},
                new Problem01().asteroidCollision(new int[]{10, 2, -5}));
    }
}
