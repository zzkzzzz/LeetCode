import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution18 {
    // another version of 15. 3sum, add on one more loop
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) { // corner case
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) { // avoid duplicated
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // avoid duplicated
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if (curr == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (curr > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

}