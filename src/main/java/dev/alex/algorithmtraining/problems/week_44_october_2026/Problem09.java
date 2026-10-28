package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Problem09 {
    /**
     * Repeatedly remove adjacent pairs of equal characters until no such pair
     * remains. Write the final characters, in order, into the beginning of chars
     * and return their count. Characters after that prefix are ignored.
     * The final result is independent of the order of pair removals.
     * Use the supplied array for the result; do not allocate another array,
     * StringBuilder, or collection. Do not change the order of surviving letters.
     * chars contains lowercase English letters; 0 <= chars.length <= 100000.
     * Examples: "abbaca" -> "ca", return 2; "azxxzy" -> "ay", return 2;
     * "aabccba" -> "a", return 1.
     */
    public int removePairs(char[] chars) {
        int left = 0;
        int copyPos = 1;
        int res = 0;
        // a b b a c a
        for(int i = 0; i < chars.length; i++) {
            if(i == left) {
                res++;
                continue;
            }

            if(left >= 0 && chars[left] == chars[i]) {
                left--;
                copyPos--;
                res--;
            } else {
                chars[copyPos++] = chars[i];
                left++;
                res++;
            }
        }

        return res;
    }
    public int removePairss(char[] chars) {
        Deque<CharPos> stack = new ArrayDeque<>();
        for(int i = 0; i < chars.length; i++) {
            if(!stack.isEmpty() && stack.peek().ch == chars[i]) {
                stack.poll();
            } else {
                int newIdx = 0;
                if(!stack.isEmpty()) {
                    newIdx = stack.peek().idx + 1;
                }
                stack.push(new CharPos(newIdx, chars[i]));
            }
        }

        int res = stack.size();
        while(!stack.isEmpty()) {
            chars[stack.peek().idx] = stack.poll().ch;
        }

        return res;
    }

    class CharPos {
        int idx;
        char ch;

        public CharPos(int idx, char ch) {
            this.idx = idx;
            this.ch = ch;
        }

    }
}
