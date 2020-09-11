import java.util.Arrays;

class Solution416 {
    // This is 0/1 knapsack problem, the thinking is same as coinChange problem
    // However, key difference is that coinChange can repeated use one type of coin
    // We can only use each number once in this question
    // which means if we choose to use this item then you cant not use it anymore

    // The problem is to sum to a specific value (sum/2)
    // by using array nums[] (from nums[0] to nums[n])
    // for each number, we can choose to use it or not use it
    // Subproblem = sum to (a specific value - nums[i]) using nums[i] to nums[n]
    // Or sum to (a specific value) using nums[i] to nums[n]

    // Rcursive top-down with memo
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        // if use primitive boolean array will make default value to false
        // we need the default value "null" to help us to do the memo
        Boolean[] dp = new Boolean[sum + 1];
        return sumTo(nums, sum, 0, dp);

    }

    public boolean sumTo(int[] nums, int sum, int index, Boolean[] dp) {

        if (sum == 0)
            return true;
        if (sum < 0)
            return false;
        if (index == nums.length)
            return false;
        if (dp[sum] != null) {
            return dp[sum];
        }

        // use the number or not use the number
        dp[sum] = sumTo(nums, sum - nums[index], index + 1, dp) || sumTo(nums, sum, index + 1, dp);

        return dp[sum];
    }

    // Iterative bottom up Solution
    // idea is from
    // (https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation)
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;

        int size = nums.length;
        boolean[][] dp = new boolean[size + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < size + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[size][sum];
    }

    // Iterative bottom up Solution
    // optimizated space complexity
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[sum];
    }
}