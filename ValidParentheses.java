//https://neetcode.io/problems/three-integer-sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
//
//The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses instance = new ValidParentheses();
        String input = "]";
        boolean result = instance.isValid(input);
        System.out.println("Answer: " + result);
    }
}




