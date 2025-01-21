//https://neetcode.io/problems/trapping-rain-water
//You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
//
//Return the maximum area of water that can be trapped between the bars.

public class TrappingRainWater {
    public int trap(int[] heights) {

        if (heights.length == 0) return 0;

        int total = 0, l = 0, r = heights.length - 1, leftMax = heights[l], rightMax = heights[r];

        while (l < r) {
            if (leftMax <= rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                total += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                total += rightMax - heights[r];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
        int[] heights = {0,2,0,3,1,0,1,3,2,1}; // Example input array
        int result = instance.trap(heights);
        System.out.println("Answer: " + result);
    }
}




