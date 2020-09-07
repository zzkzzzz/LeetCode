class Solution264 {
    // dp bottom up
    // time complexity=O(n)
    // space complexity=O(n)
    // 3 arrays store the result*[2,3,5]
    // UglyNumbers: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
    // dp[0] 1×2, 2×2, 3×2, 4×2, 5×2, …
    // dp[1] 1×3, 2×3, 3×3, 4×3, 5×3, …
    // dp[2] 1×5, 2×5, 3×5, 4×5, 5×5, …
    // subproblem=min(dp[0][a],dp[1][b],dp[2][c])
    // then a++ or b++ or c++
    // imaging they are three queues
    // every time will choose the smallest one in top of the 3 queues
    // then the smallest one will pop out from that queue
    public int nthUglyNumber(int n) {
        int[][] dp = new int[3][n + 1];
        int result = 1;
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < n - 1; i++) {
            dp[0][i] = result * 2;
            dp[1][i] = result * 3;
            dp[2][i] = result * 5;

            result = Math.min(Math.min(dp[0][a], dp[1][b]), dp[2][c]);

            if (result == dp[0][a])
                a++;

            if (result == dp[1][b])
                b++;

            if (result == dp[2][c])
                c++;
        }
        return result;

    }

}