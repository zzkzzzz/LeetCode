class Solution72 {
    // s1 -> s2
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // dp table stores the min distance convert from 0..i of s1 to 0..j of s2
        int[][] dp = new int[m + 1][n + 1];

        // base case
        // dp[0][0]: convert "" to "" only need 0 steps
        // dp[0][1]: convert "" to "" only need 0 steps
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        // 自底向上求解
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}