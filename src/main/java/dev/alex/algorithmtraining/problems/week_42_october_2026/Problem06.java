package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem06 {
    /*
     * Given a string s containing lowercase English letters and parentheses
     * '(' and ')', remove the minimum number of parentheses so that the
     * remaining parentheses are valid. Return any result achieving that
     * minimum. Letters must not be removed, and the relative order of all
     * retained characters must stay unchanged. Do not insert characters.
     *
     * Valid means that every closing parenthesis matches a preceding
     * opening parenthesis, with correct nesting, and every opening
     * parenthesis is matched. Letters do not affect validity. A string
     * without parentheses, including the empty string, is valid.
     *
     * Constraints:
     * - 0 <= s.length() <= 100000
     * - characters are a-z, '(' and ')'
     *
     * Examples:
     * - "a)b(c)d" returns "ab(c)d" (remove one parenthesis).
     * - "(ab" returns "ab" (remove one parenthesis).
     * - "(a)(b)" returns "(a)(b)" (remove none).
     * - "(a(b)" may return "a(b)" or "(ab)"; both remove one.
     * - (((ab
     * - ))z(df
     * - )a(b)(c
     */
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int idx = 0;
        Stack<CharPosition> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(new CharPosition(ch, idx));
            } else if (ch == ')') {
                if(stack.isEmpty()) {
                    continue;
                } else {
                    if (stack.peek().ch == '(') {
                        stack.pop();
                    }
                }
            }
            sb.append(ch);
            idx++;
        }

        if(!stack.isEmpty()) {
            var exclude  =stack.stream().map(cp -> cp.idx).collect(Collectors.toSet());
            StringBuilder nw = new StringBuilder();
            var str = sb.toString();
            for(int i = 0; i < str.length(); i++) {
                if(!exclude.contains(i)) {
                    nw.append(str.charAt(i));
                }
            }

            sb = nw;
        }

        return sb.toString();
    }

    class CharPosition {
        char ch;
        int idx;
        public CharPosition(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
}
