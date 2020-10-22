import java.util.Map;
import java.util.HashMap;

class Solution167 {

    // Time complexity: O(n), Space Complexity: O(1)
    // Two poniter
    public int[] twoSum(int[] nums, int target) {
        int[] indice = new int[2];
        if (nums == null || nums.length < 2)
            return indice;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }

    // if use hashmap => Time complexity: O(n), Space Complexity: O(n)

}