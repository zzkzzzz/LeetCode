// botton-up Tabulation
// subproblem  larger one between using all numbers and using all but first kind number
// dp[j] = Math.max(dp[j], i * dp[j - i]);

class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // set dp[0] to 1 to make sure
        dp[0] = 1;
        // loop through all the possible interger array
        // i cant reach n, bcs 10 cant split into 10 and 0
        for (int i = 1; i < n; i++) {
            // loop through all the amount
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    dp[j] = Math.max(dp[j], i * dp[j - i]);
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        Solution343 solution = new Solution343();
        System.out.println(solution.integerBreak(10));
    }
}