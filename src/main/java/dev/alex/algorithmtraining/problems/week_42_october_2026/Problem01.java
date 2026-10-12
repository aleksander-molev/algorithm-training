package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;

public class Problem01 {
    /*
     * Asteroids lie on a line in the order given by asteroids.
     * Each nonzero value describes an asteroid: its absolute value is its size;
     * positive means moving right, negative means moving left.
     * All asteroids move at the same speed.
     * When two asteroids collide, the smaller one disappears. If their sizes
     * are equal, both disappear. Asteroids moving in the same direction never
     * collide. Continue until no more collisions can occur.
     * Return the surviving asteroids in their original left-to-right order.
     * Do not modify the input.
     *
     * Constraints:
     * - 0 <= asteroids.length <= 100000
     * - -1000000000 <= asteroids[i] <= 1000000000
     * - asteroids[i] != 0
     *
     * Examples:
     * - [5, 10, -5] returns [5, 10].
     * - [8, -8] returns [].
     * - [10, 2, -5] returns [10].
     */
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();

        //-1 -2, 5, 10 -5
        for(int astSize : asteroids) {
            left.push(astSize);
        }

        while(!left.empty()) {
            int r = chooseRight(left, right);
            if(left.isEmpty()) {
                right.push(r);
                continue;
            }
            int l = left.pop();
            if((l > 0 && r > 0) || (l < 0 && r < 0) || (r >0 && l < 0) ) {
                right.push(r);
                right.push(l);
                continue;
            }
            if(Math.abs(r) == Math.abs(l)) {
                continue;
            } else if(Math.abs(r) > Math.abs(l)) {
                right.push(r);
            } else {
                left.push(l);
            }
        }

        int []  result = new int [right.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = right.pop();
        }

        return result;
    }

    private int chooseRight(Stack<Integer> left, Stack<Integer> right) {
        if(right.isEmpty()) {
            return left.pop();
        }

        return right.pop();
    }
}
