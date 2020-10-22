import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution219 {
    // Time complexity: O(n), Space Complexity: O(n)
    // HashMap
    // key => number
    // value => index
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> distinct = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (distinct.containsKey(nums[i]) && Math.abs(i - distinct.get(nums[i])) <= k) {
                return true;
            }
            distinct.put(nums[i], i);
        }
        return false;
    }

    // Time complexity: O(n), Space Complexity: O(n)
    // iterates over the array using a sliding window
    // the size of the hashset will be constant k
    // keeo removing the previous element and add new elements in
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}