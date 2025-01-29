//https://neetcode.io/problems/longest-substring-without-duplicates
//Given a string s, find the length of the longest substring without duplicate characters.
//
//A substring is a contiguous sequence of characters within a string.

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringNoRepeatingChar {

    // Time: O(n * m) where n the length of string (iteration through the for loop) and m is removing operation (number of unique chars in the map)
    // Space: O(n) stores at most m characters and in the worst case the map will store all characters in the passed string (n)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int maxLen = 1;
        HashMap<Character, Integer> uniqueChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!uniqueChars.containsKey(currentChar)) {
                uniqueChars.put(currentChar, i);
                maxLen = Math.max(maxLen, uniqueChars.size());
                System.out.println(uniqueChars + "; i:" + i + "; currentChar: '" + currentChar + "'");
            } else {
                // Remove char from set as well as everything before it
                int indexToRemove = uniqueChars.get(currentChar);
                uniqueChars.entrySet().removeIf(entry -> entry.getValue() <= indexToRemove);
                uniqueChars.put(currentChar, i);
            }
        }

        return maxLen;
    }

//    Time Complexity: O(n), as each character is processed at most twice (once added and once removed from the HashSet).
//    Space Complexity: O(k), where k is the number of unique characters in the string (worst case: O(n) if all characters are unique).
    public int lengthOfLongestSubstringHashSet(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        int maxLen = 1, l = 0;

        for (int r = 0; r < s.length(); r++) {
            while (uniqueChars.contains(s.charAt(r))) {
                uniqueChars.remove(s.charAt(l));
                l++;
            }
            uniqueChars.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        HashMap<Character, Integer> uniqueChars = new HashMap<>();
        int l = 0, maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            if (uniqueChars.containsKey(s.charAt(r))) {
                l = Math.max(uniqueChars.get(s.charAt(r)) + 1, l);
            }
            uniqueChars.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstringNoRepeatingChar instance = new LongestSubstringNoRepeatingChar();
        String input = "auxyzxyz"; // Example input array
        int result = instance.lengthOfLongestSubstringHashSet(input);
        System.out.println("Answer: " + result);
    }
}




