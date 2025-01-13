//https://neetcode.io/problems/three-integer-sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
//
//The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // allows for skipping of duplicates implementation
        List<List<Integer>> triplets = new ArrayList<>();

        for (int l = 0; l < nums.length; l++) {
            if (nums[l] > 0) break; // sum cannot be 0 if no numbers are negative
            if (l > 0 && nums[l] == nums[l - 1]) continue; // skip duplicates (possible because array has been sorted)

            // Two Pointer Algorithm
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                System.out.println("l: " + l + ", m: " + m + ", r: " + r + "; sum: " + sum);
                if (sum == 0) {
                    triplets.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    m++;
                    r--;
                    while (m < r && nums[r] == nums[r + 1]) // skip duplicates (out of bounds not possible bc of r-- on previous line)
                        r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    m++;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] numbers = {-2, 0, 0, 2, 2}; // Example input array
//        int[] numbers = {0, 0, 0}; // Example input array
        List<List<Integer>> result = instance.threeSum(numbers);
        System.out.println("Answer: " + result);
    }
}




