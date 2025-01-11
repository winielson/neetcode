import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements within the array.
//
//The test cases are generated such that the answer is always unique.
//
//You may return the output in any order.

public class TopKFrequent {
    // T: O(nlogn), S: O(n + k)
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

    // T: O(n), S: O(n)
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        // Key is index which represents count and values are a list of the numbers that have that count
        // Trick: Since no num in nums can appear more times than the length of the nums array, each bucket
        // can be serve as a frequency count
        // ex: nums = [6, 6, 6] in this case count is {0: [], 1: [], 2: [], 3: [6]}
        Map<Integer, Integer> count = new HashMap<>(); // <number in the array, how many times it shows up in the array>
        List<Integer>[] freq = new List[nums.length+1];

        // Create the buckets
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Count the frequency for each number
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Now that a count for the values in the array is done
        // Based on the entry value (count), go to the respective bucket then append
        // the key (number that shows up in the array) to the bucket's list
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        System.out.println("freq: "  + Arrays.toString(freq));
        int[] response = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) { // if array in value freq[i] is empty, the block does not get processed

                // sets response at index as n then iterates the index. It is same as the following
                // response[index] = n;
                // index++;
                response[index++] = n;
                System.out.println("index: " + index + "; response: " + Arrays.toString(response) + "; n: " + n);
                if (index == k) {
                    return response;
                }
            }
        }
        return response;
    }

    public static void main(String[] args) {
        TopKFrequent instance = new TopKFrequent();
        int[] nums = new int[]{60,2, 4,5,60, 60, 60, 2};
        int k = 2;
        int[] result = instance.topKFrequentBucketSort(nums, k);
        System.out.println("Answer: " + Arrays.toString(result));
    }
}




