import java.util.List;

class Solution120 {
    // dp top down
    // time complexity=O(n^2)
    // space complexity=O(n^2)
    // subproblem = the minimum total of any point
    // = minimum one from previous adjacent total+ current
    // = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]

    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        int[][] dp = new int[row][row];
        int min = Integer.MAX_VALUE;
        dp[0][0] = triangle.get(0).get(0);

        if (row == 0)
            return 0;
        if (row == 1)
            return dp[0][0];

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                // if its the start one of the row
                if (j == 0)
                    // only the start of previous row is adjacent
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                // if its the end one of the row
                else if (j == i)
                    // only the end of previous row is adjacent
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    // two adjacent points from previous row
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);

                // if reach to the last row
                // find the minimum one in the row
                if (i == (row - 1))
                    min = Math.min(min, dp[i][j]);
            }

        }
        return min;
    }

    // dp bottom up
    // only need 1d array
    // time complexity=O(n^2)
    // space complexity=O(n)
    // subproblem = the minimum total of any point
    // = minimum one of adjacent total from previous row + current
    // = min(dp[j], dp[j+1]) + current

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();

        int[] dp = new int[row + 1];
        for (int i = 0; i < row; i++) {
            // row - i => length of current row
            // if the point is the left edge, dp[j+1] will be out of array bounds
            // then declared as size row+1, dp[j+1] will be 0
            // only the first loop will reach the bound of the array
            // bcs from bottom to up, the length of the row is decreasing
            for (int j = 0; j < (row - i); j++) {
                // dp[j] and dp[j+1] are the adjacent point from previous row
                // triangle.get(row - i - 1).get(j) is the current point
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(row - i - 1).get(j);
            }
        }
        return dp[0];
    }
}