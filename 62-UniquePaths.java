
// subproblem = paths come from top + paths come from left
import java.util.Arrays;

class Solution62 {
    // dp bottom-up
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    // optimizated the space complexity
    // 2 * 1d array
    public int uniquePaths_2(int m, int n) {
        int[] pre = new int[m];
        int[] cur = new int[m];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        cur[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cur[j] = pre[j] + cur[j - 1];
            }
            pre = cur;
            cur[0] = 1;
        }
        return cur[m - 1];
    }

    // optimizated the space complexity
    // 1d array
    // actually can only use one 1d array to solve the problem
    // dp[j] =dp[j] + dp[j - 1];
    public int uniquePaths_3(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[m - 1];
    }

}