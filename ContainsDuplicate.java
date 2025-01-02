import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numsTracker = new HashSet();

        for (int num : nums) {
            if(numsTracker.contains(num)) {
                return true;
            }

            numsTracker.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 1}; // Example input array
        boolean result = cd.hasDuplicate(nums);
        System.out.println("Contains duplicate: " + result);
    }
}




