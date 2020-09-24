class Solution931 {
    // dp top down solution
    // time complexity=O(n^2)
    // space complexity=O(n^2)
    // subproblm =
    // The minimum path to get to element A[i][j]
    // is the minimum of A[i - 1][j - 1],A[i - 1][j] and A[i - 1][j + 1]
    // then plus + A[i][j]
    public int minFallingPathSum(int[][] A) {
        int size = A.length;
        int[][] dp = new int[size][size];
        dp[0] = A[0];
        int max = Integer.MAX_VALUE;

        if (A.length == 1)
            return A[0][0];

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                else if (j == size - 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i][j];
                if (i == size - 1)
                    max = Math.min(max, dp[i][j]);
            }

        }
        return max;
    }
}