class Solution198 {
    // Iterative + memo (bottom-up)
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        return dp[nums.length - 1];
    }

    // Iterative + 2 variables (bottom-up)
    // We can notice that in the previous step we use only dp[i] and dp[i-1], so
    // going just 2 steps back. We can hold them in 2 variables instead. This
    // optimization is met in Fibonacci sequence creation and some other problems
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}