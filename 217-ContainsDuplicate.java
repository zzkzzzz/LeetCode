import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution217 {
    // Time complexity: O(n^2), Space Complexity: O(1)
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // Time complexity: O(nlog(n)), Space Complexity: O(1)
    // Arrays.sort(Object[]) is based on the TimSort algorithm, giving us a time
    // complexity of O(n log(n)). In short, TimSort makes use of the Insertion sort
    // and the MergeSort algorithms.
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // Time complexity: O(n), Space Complexity: O(n)
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    // FP
    public boolean containsDuplicate4(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().count();
    }

    public boolean containsDuplicate5(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !distinct.add(num));
    }
}