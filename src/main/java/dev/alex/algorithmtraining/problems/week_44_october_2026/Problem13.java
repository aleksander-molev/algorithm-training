package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Problem13 {
    /**
     * Normalize an absolute Unix-style file path without accessing a filesystem.
     * Consecutive slashes act as one separator. A component "." means the current
     * directory; ".." means the parent (at root, stay at root). All other nonempty
     * components, including "...", are ordinary directory names.
     * Return a path beginning with one slash, with no redundant components or
     * trailing slash unless the result is root. No symbolic links are involved.
     * Constraints: 1 <= path.length() <= 100000; path begins with '/'; characters
     * are English letters, digits, '.', '_', and '/'.
     * Examples: "/home//user/../docs/" -> "/home/docs";
     * "/../../a/./b/" -> "/a/b"; "/a/.../b/../c" -> "/a/.../c".
     */
    public String normalize(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        stack.add("/"); // add root
        for(int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if(ch == '/') { // handle directory separator
                if (stack.peek().equals("/")) {
                    continue;
                }
                stack.push("/");
                continue;
            }
            if(ch == '.') {
                String token = "";
                while(i < path.length() && path.charAt(i) != '/') {
                    token += path.charAt(i);
                    i++;
                }
                if (token.equals("..")) {
                    if(stack.size() != 1) {
                        if("/" == stack.remove()) {
                            stack.remove();
                        }
                    }
                } else if(token.equals(".")) {
                    continue;
                } else { // simple name
                    stack.push(token);
                    stack.push("/");
                }
            } else {
                String token = "";
                while(i < path.length() && path.charAt(i) != '/') {
                    token += path.charAt(i);
                    i++;
                }
                stack.push(token);
                stack.push("/");
            }
        }

        StringBuilder result = new StringBuilder();
        if(stack.size() > 1) stack.remove();
        while(!stack.isEmpty()) {
            result.insert(0, stack.remove());
        }

        return result.toString();
    }
}
