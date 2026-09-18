package dev.alex.algorithmtraining.problems.week_38_september_2026;

public class Problem05 {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters.length == 1) {
            return letters[0];
        }

        int lo = 0;
        int hi = letters.length - 1;
        char res = letters[lo];

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                res = letters[mid];
            }
        }

        return res;
    }
}
