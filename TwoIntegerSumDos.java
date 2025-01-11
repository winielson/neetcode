//https://neetcode.io/problems/two-integer-sum-ii
//Given an array of integers numbers that is sorted in non-decreasing order.
//
//Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
//
//There will always be exactly one valid solution.
//
//Your solution must use O(1)O(1) additional space.

import java.util.Arrays;

public class TwoIntegerSumDos {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while(l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l+1, r+1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{0,0};
    }

    public static void main(String[] args) {
        TwoIntegerSumDos instance = new TwoIntegerSumDos();
        int[] numbers = {1, 2, 3, 4}; // Example input array
        int target = 3;
        int[] result = instance.twoSum(numbers, target);
        System.out.println("Answer: " + Arrays.toString(result));
    }
}




