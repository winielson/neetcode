// https://neetcode.io/problems/is-palindrome
// Given a string s, return true if it is a palindrome, otherwise return false.
//
// A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] filteredCharArray = filtered.toCharArray();

        int i = 0;
        int j = filteredCharArray.length - 1;
        while (i < j) {
            if (filteredCharArray[i] != filteredCharArray[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }

    public boolean isPalindromeBetterSpaceComplexity(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            // Skip non alpha numeric values
            while (l < r && !alphaNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !alphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome instance = new ValidPalindrome();
        String input = "Was it a car or a cat I saw?"; // Example input array
        boolean result = instance.isPalindromeBetterSpaceComplexity(input);
        System.out.println("Answer: " + result);
    }
}




