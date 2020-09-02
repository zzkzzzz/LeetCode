// subproblem = minimum(come from top, come from left)+current 
// space complexity=O(n) => the width of the given array
// time  complexity=O(mn) => two for loop (rows and colums)
class Solution64 {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width];

        // loop over row
        for (int[] row : grid) {
            // loop over column
            for (int j = 0; j < width; j++) {
                // if its grid[0][x] which means can only come from top
                // there is no path from left
                if (j == 0)
                    dp[j] = dp[j] + row[j];
                else
                    // if dp[j] is 0 which means its the first row
                    // which means there is no path from top, only can come from left
                    // set it to Integer.MAX_VALUE,
                    // then the minimum one will always be the path from left
                    dp[j] = Math.min(dp[j] == 0 ? Integer.MAX_VALUE : dp[j], dp[j - 1]) + row[j];
            }
        }
        return dp[width - 1];
    }
}