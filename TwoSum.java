import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = nums.length-1; i >= 0; i--) {
            hashMap.put(nums[i], i);
        }

        System.out.println("Answer: " + hashMap.toString());


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hashMap.containsKey(diff) && hashMap.get(nums[i]) != i) {
                return new int[]{i, hashMap.get(diff)};
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum instance = new TwoSum();
        int[] nums = {1, 2, 3, 4, 1}; // Example input array
        int target = 5;
        int[] result = instance.twoSum(nums, target);
        System.out.println("Answer: " + Arrays.toString(result));
    }
}




