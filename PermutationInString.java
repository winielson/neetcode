//https://neetcode.io/problems/permutation-string
//Given a string s, find the length of the longest substring without duplicate characters.
//
//A substring is a contiguous sequence of characters within a string.

import java.util.Arrays;
import java.util.Objects;

public class PermutationInString {
    public static String sortString(String string) {
        if (string == null || string.isEmpty()) return string;
        char[] chars = string.toCharArray();
        Arrays.sort(chars); // Sorts in natural order (lexicographical)
        return new String(chars);
    }

    public boolean checkInclusion(String s1, String s2) {
        String sorted1 = sortString(s1);
        int l = 0, r = s1.length();

        while (r <= s2.length()) {
            System.out.println("sorted1: " + sorted1 + "; sortString(s2.substring(l, r)): " + sortString(s2.substring(l, r)) + "; l: " + l + "; r: " + r);
            // NOTE: for s2.substring(l, r), the endIndex r is +1 of the substring
            // ex: for 'abc', 'abc'.substring(0, 2) == 'ab'
            if (Objects.equals(sorted1, sortString(s2.substring(l, r)))) {
                return true;
            }

            l++;
            r++;
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString instance = new PermutationInString();
        String input1 = "adc";
        String input2 = "dcda";
        boolean result = instance.checkInclusion(input1, input2);
        System.out.println("Answer: " + result);
    }
}




