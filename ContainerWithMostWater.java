//https://neetcode.io/problems/max-water-container
//You are given an integer array heights where heights[i] represents the height of the ithith bar.

//You may choose any two bars to form a container. Return the maximum amount of water a container can store.

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int max = 0, l = 0, r = heights.length - 1;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            if (area > max) {
                max = area;
            }

            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater instance = new ContainerWithMostWater();
        int[] heights = {1,7,2,5,4,7,3,6}; // Example input array
        int result = instance.maxArea(heights);
        System.out.println("Answer: " + result);
    }
}




