package dev.alex.algorithmtraining;


import java.util.HashMap;
import java.util.Map;

public class Problem01 {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("", "a"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> availableLetters = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++) {
            availableLetters.put(magazine.charAt(i), availableLetters.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            if(!availableLetters.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            int charsLeft = availableLetters.get(ransomNote.charAt(i)) - 1;
            if(charsLeft == 0) {
                availableLetters.remove(ransomNote.charAt(i));
            } else {
                availableLetters.put(ransomNote.charAt(i), charsLeft);
            }
        }

        return true;
    }
}
