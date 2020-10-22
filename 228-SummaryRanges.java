import java.util.List;
import java.util.ArrayList;

class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int left = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || Math.abs(nums[i] - nums[i - 1]) > 1) {
                if (i - 1 == left)
                    result.add(String.format("%d", nums[left]));
                else
                    result.add(String.format("%d->%d", nums[left], nums[i - 1]));
                left = i;
            }
        }
        return result;
    }
}