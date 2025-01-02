import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements within the array.
//
//The test cases are generated such that the answer is always unique.
//
//You may return the output in any order.

public class TopKFrequent {
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent instance = new TopKFrequent();
        int[] nums = new int[]{1,2};
        int k = 2;
        int[] result = instance.topKFrequentHeap(nums, k);
        System.out.println("Answer: " + Arrays.toString(result));
    }
}




