class Solution516 {
    // Subproblem
    // In a char array n[], if we have n(j) == n(i) (j<i)
    // longestPalindromeSubseq = dp[j][i] = 2 + dp[j + 1][i - 1]
    // the "2" means n(j) and n(i)
    // dp[j + 1][i - 1]=>longestPalindromeSubseq between j+1 and i-1
    // longestPalindromeSubseq between j+1 and i-1 we already calculated before in
    // similar way
    // if we do not have n(j) == n(i) between j and i
    // then longestPalindromeSubseq = max(dp[j][i - 1], dp[j + 1][i])
    // dp[j][i - 1]=>longestPalindromeSubseq between j and i-1OR
    // dp[j + 1][i]=>longestPalindromeSubseq between j+1 and i

    public int longestPalindromeSubseq(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            // from i to i, longestPalindromeSubseq is the char itself
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j))
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                else
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
            }
        }
        return dp[0][size - 1];

    }
}