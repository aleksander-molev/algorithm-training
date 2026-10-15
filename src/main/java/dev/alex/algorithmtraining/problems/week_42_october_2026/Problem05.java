package dev.alex.algorithmtraining.problems.week_42_october_2026;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

import static java.lang.Character.isDigit;

public class Problem05 {
    /*
     * Decode a valid encoded string. A construction k[part] means repeat
     * the decoded content of part exactly k times. Constructions can be
     * nested or placed next to each other, and ordinary lowercase letters
     * can appear before, between, or after constructions.
     * Return the fully decoded string in the original order.
     *
     * The input is guaranteed valid: brackets are balanced, every opening
     * bracket is immediately preceded by a positive decimal repetition
     * count, and digits appear only in repetition counts. Counts may have
     * multiple digits. There are no spaces. No validation is required.
     *
     * Constraints:
     * - 0 <= s.length() <= 200
     * - characters are a-z, 0-9, [ and ]
     * - 1 <= each repetition count <= 100
     * - decoded result length <= 100000
     * - empty input returns an empty string
     *
     * Examples:
     * - "3[a]2[bc]" returns "aaabcbc".
     * - "2[a3[b]]" returns "abbbabbb".
     *   First 3[b] becomes bbb; then abbb is repeated twice.
     * - "xy2[z]q" returns "xyzzq".
     */
    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == ']') {
                String token = readBack(stack);
                int nTimes = readNtimes(stack);
                while(nTimes-- > 0) {
                    sb.append(token);
                }
                for(char bc : sb.toString().toCharArray())
                    stack.push(bc);
                sb = new StringBuilder();
            } else {
                stack.push(ch);
            }
        }

        sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private int readNtimes(Stack<Character> stack) {
        if(stack.isEmpty() || stack.peek() != '[') {
            throw new RuntimeException("ERROR expected '['");
        }
        stack.pop();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && isDigit(stack.peek())) {
            sb.insert(0, stack.pop());
        }

        return Integer.parseInt(sb.toString());
    }

    private String readBack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peek() != '[' ) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
