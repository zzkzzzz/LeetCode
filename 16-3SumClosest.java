import java.util.Arrays;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) <= closest) {
                        sum = nums[i] + nums[lo] + nums[hi];
                        if (sum < target)
                            lo++;
                        else
                            hi--;
                        closest = Math.abs(sum - target);

                    } else if (nums[i] + nums[lo] + nums[hi] < target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return sum;
    }
}
