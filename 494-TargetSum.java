class Solution494 {
    // 0/1 knapsack problem
    // total ways to sum to S=
    // total ways to sum to (S-nums[i]) + total ways to sum to (S+nums[i])
    public int findTargetSumWays(int[] nums, int S) {
        return sumWaysHelper(nums, S - nums[0], 1) + sumWaysHelper(nums, S + nums[0], 1);
    }

    public int sumWaysHelper(int[] nums, int sum, int index) {

        if (index == nums.length) {
            if (sum == 0)
                return 1;
            else
                return 0;
        }

        return sumWaysHelper(nums, sum - nums[index], index + 1) + sumWaysHelper(nums, sum + nums[index], index + 1);

    }

    // 0/1 knapsack problem
    // total ways to sum to S =
    // total ways to sum to (S-nums[i]) + total ways to sum to (S+nums[i])
    // dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i]]
    // In this knapsack problem,
    // Every number must be use once, and the traget sum is from -sum to sum.
    // unlike coin change problem, no need use all coins and can use multiple times
    // its more like Partion Equal Subset Sum (416)
    public int findTargetSumWays2(int[] nums, int S) {

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // left bound = -sum
        // right bound = sum
        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum, check below graph
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {

                if (j + nums[i - 1] < 2 * sum + 1)
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                if (j - nums[i - 1] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum + S];
    }

}