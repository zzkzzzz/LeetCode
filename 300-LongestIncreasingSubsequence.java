import java.util.Arrays;

class Solution300 {
    // recursive solution (TLE)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        return helper(nums, 0, 1, 1);
    }

    public int helper(int[] nums, int start, int end, int length) {
        if (end == nums.length)
            return length;
        if (nums[start] < nums[end])
            return Math.max(helper(nums, end, end + 1, length + 1), helper(nums, start, end + 1, length));
        else {
            return Math.max(helper(nums, start, end + 1, length), helper(nums, end, end + 1, 1));
        }
    }

    // TODO: try to add a memo , not working
    public int helper2(int[] nums, int start, int end, int[] dp) {
        int max = 1, way1, way2;
        if (end == nums.length)
            return 1;
        if (dp[start] != 0)
            return dp[start];
        if (nums[start] < nums[end]) {
            way1 = helper2(nums, end, end + 1, dp) + 1;
            way2 = helper2(nums, start, end + 1, dp);
        } else {
            way1 = helper2(nums, start, end + 1, dp);
            way2 = helper2(nums, end, end + 1, dp);
        }
        dp[start] = Math.max(way1, way2);
        max = Math.max(dp[start], max);
        return max;
    }

    // iterative bottom-up DP Solution
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // dp[] to store the longest length from nums[0] to nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;

        // if nums[i] is end of the array (start from nums[1])
        // num[j] is from num[0] to num[i-1]
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // if the current element(num[i]) is greater than the previous element(nums[j]),
                // we can safely add 1 to the value of previous max length(dp[j]+1).
                // Since the previous max length was also calculated in a similar manner
                if (nums[i] > nums[j]) {
                    // It is possible that dp[i] already has larger value from some previous nums[j]
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;

    }
}