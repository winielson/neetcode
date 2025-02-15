//https://neetcode.io/problems/minimum-window-with-characters
//Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
//
//You may assume that the correct output is always unique.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCharCountMap = new HashMap<>(); // stores characters and count of each in t
        Map<Character, Integer> windowCharCountMap = new HashMap<>(); // used to compare char and count of each with tCharCountMap
        int need = 0, have = 0;
        int[] shortestWindow = {-1, -1};

        for (char c : t.toCharArray()) {
            tCharCountMap.put(c, tCharCountMap.getOrDefault(c, 0) + 1);
            windowCharCountMap.putIfAbsent(c, 0);
            need++;
        }

        int l = 0;
        for (int r = l; r < s.length(); r++) {
            Character currentChar = s.charAt(r);

            // Check if current character is needed (in the t string)
            if (tCharCountMap.containsKey(currentChar)) {
                // Increment have when char exists in t and we need more of that char in the window
                if (windowCharCountMap.get(currentChar) < tCharCountMap.get(currentChar)) {
                    have++;
                }

                // Add to window map when there is a match
                windowCharCountMap.put(currentChar, windowCharCountMap.getOrDefault(currentChar, 0) + 1);
            }

            while (have == need && l <= r) {
                if (shortestWindow[0] == -1 || r - l < shortestWindow[1] - shortestWindow[0]) {
                    shortestWindow = new int[]{l, r};
                }

                if (windowCharCountMap.containsKey(s.charAt(l))) {
                    windowCharCountMap.replace(s.charAt(l), windowCharCountMap.get(s.charAt(l)) - 1);

                    // If char at left pointer's count is less then what is needed after moving the window
                    // then we do not have what we need any more and subtract 1 from have
                    if (windowCharCountMap.get(s.charAt(l)) < tCharCountMap.get(s.charAt(l))) {
                        have--;
                    }
                }

                l++;
            }
        }

        if (shortestWindow[0] == -1) return "";

        return s.substring(shortestWindow[0], shortestWindow[1] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring instance = new MinimumWindowSubstring();
        String input1 = "a";
        String input2 = "a";
        String result = instance.minWindow(input1, input2);
        System.out.println("Answer: " + result);
    }
}




