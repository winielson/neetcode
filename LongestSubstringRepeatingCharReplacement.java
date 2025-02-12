//https://neetcode.io/problems/longest-repeating-substring-with-replacement
//You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
//
//After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

import java.util.HashSet;

public class LongestSubstringRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        HashSet<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            int countOfCurrentCharacterInWindow = 0, l = 0;

            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    countOfCurrentCharacterInWindow++;
                }

                // windowSize - countOfCurrentCharacterInWindow <= k
                // Need to review this magic. Not intuitive enough to me since I can not explain well.
                while ((r - l + 1) - countOfCurrentCharacterInWindow > k) {
                    if (s.charAt(l) == c) {
                        countOfCurrentCharacterInWindow--;
                    }
                    l++;
                }

                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstringRepeatingCharReplacement instance = new LongestSubstringRepeatingCharReplacement();
        String input = "AAABABB"; // Example input array
        int k = 1;
        int result = instance.characterReplacement(input, k);
        System.out.println("Answer: " + result);
    }
}




