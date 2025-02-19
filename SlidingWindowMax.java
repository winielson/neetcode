//https://neetcode.io/problems/sliding-window-maximum

//You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array.
//The window slides one position to the right until it reaches the right edge of the array.
//
//Return a list that contains the maximum element in the window at each step.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxIntInEachWindow = new int[nums.length - k + 1];

        int r = k;
        for (int l = 0; r <= nums.length; l++) {
            int windowMax = Arrays.stream(Arrays.copyOfRange(nums, l, r)).max().getAsInt();

            maxIntInEachWindow[l] = windowMax;

            r++;
        }

        return maxIntInEachWindow;
    }

    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        int[] maxIntInEachWindow = new int[nums.length - k + 1];
        // Keeps indexes of elements in nums in descending order
        Deque<Integer> indexDeque = new ArrayDeque<>();
        int l = 0, r = 0;

        while (r < nums.length) {
            // Ensures deque maintains descending order
            while (!indexDeque.isEmpty() && nums[indexDeque.getLast()] < nums[r]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(r);

            // Remove from deque when left pointer is no longer in the window
            if (l > indexDeque.getFirst()) {
                indexDeque.removeFirst();
            }

            // When window is the size of k, the given size of the window,
            if (r + 1 >= k) {
                // get the first value in the deque and add to the output array
                maxIntInEachWindow[l] = nums[indexDeque.getFirst()];
                l++; // increment in here because at the start both pointers start at 0
            }
            r++;
        }

        return maxIntInEachWindow;
    }

    public static void main(String[] args) {
        SlidingWindowMax cd = new SlidingWindowMax();
        int[] nums = {1,3,1,2,0,5}; // Example input array
        int k = 3;
        int[] result = cd.maxSlidingWindowDeque(nums, k);
        System.out.println("Max values in each window: " + Arrays.toString(result));
    }
}




