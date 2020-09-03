// subproblem= min(previous one, the one before previous one) + current one
// dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
class Solution746 {
    // dp bottom up
    // space complexity=O(n)
    // time complexity=O(n)
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return 0;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[length - 1], dp[length - 2]);
    }

    // optimizated space complexity
    // space complexity=O(1)
    // time complexity=O(n)
    public int minCostClimbingStairs2(int[] cost) {
        int length = cost.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return 0;
        int dp1 = cost[0];
        int dp2 = cost[1];
        int temp;
        for (int i = 2; i < length; i++) {
            temp = dp2;
            dp2 = Math.min(dp1, dp2) + cost[i];
            dp1 = temp;
        }
        return Math.min(dp1, dp2);
    }
}