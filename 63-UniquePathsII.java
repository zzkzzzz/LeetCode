// subproblem = paths come from top + paths come from left
// add more conditions => if got obstacle, then the paths will be 0
class Solution63 {
    // dp bottom up
    // 2D array
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if (column == 0 || row == 0)
            return 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // no obstacle
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0)
                        obstacleGrid[i][j] = 1;
                    else if (i == 0)
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    else if (j == 0)
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    else
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                }
                // got obstacle
                else {
                    obstacleGrid[i][j] = 0;
                }
            }

        }
        return obstacleGrid[row - 1][column - 1];
    }

    // optimizated the space complexity
    // 1d array
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}