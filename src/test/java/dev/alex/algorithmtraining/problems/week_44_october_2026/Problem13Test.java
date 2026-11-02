package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem13Test {
    @Test void example1() {
        assertEquals("/home/docs", new Problem13().normalize("/home//user/../docs/"));
    }
    @Test void example2() {
        assertEquals("/a/b", new Problem13().normalize("/../../a/./b/"));
    }
    @Test void example3() {
        assertEquals("/a/.../c", new Problem13().normalize("/a/.../b/../c"));
    }
    @Test void rootAndLiteralNames() {
        Problem13 solution = new Problem13();
        assertEquals("/", solution.normalize("/"));
        assertEquals("/", solution.normalize("////../.././"));
        assertEquals("/", solution.normalize("/a/b/../../.."));
        assertEquals("/.a/..b/a../.../_1", solution.normalize("/.a/..b/a../.../_1/"));
        assertEquals("/a/c", solution.normalize("/a/./b/../c"));
    }

    @Test void generatedPathsAgainstComponentOracle() {
        Problem13 solution = new Problem13();
        java.util.Random random = new java.util.Random(13);
        String[] components = {"a", "b2", ".", "..", "...", ".a", "a..", "_"};
        for (int trial = 0; trial < 2000; trial++) {
            StringBuilder path = new StringBuilder("/");
            java.util.List<String> expected = new java.util.ArrayList<>();
            int count = random.nextInt(30);
            for (int j = 0; j < count; j++) {
                path.append("/".repeat(1 + random.nextInt(3)));
                String component = components[random.nextInt(components.length)];
                path.append(component);
                if (component.equals("..")) {
                    if (!expected.isEmpty()) expected.remove(expected.size() - 1);
                } else if (!component.equals(".")) {
                    expected.add(component);
                }
            }
            if (random.nextBoolean()) path.append("///");
            String actual = solution.normalize(path.toString());
            assertEquals("/" + String.join("/", expected), actual, path.toString());
            assertEquals(actual, solution.normalize(actual));
        }
    }

    @Test void maximumLengthShapes() {
        Problem13 solution = new Problem13();
        assertEquals("/", solution.normalize("/".repeat(100000)));
        String oneName = "/" + "a".repeat(99999);
        assertEquals(oneName, solution.normalize(oneName));
        String manyNames = "/a".repeat(50000);
        assertEquals(manyNames, solution.normalize(manyNames));
    }
}
