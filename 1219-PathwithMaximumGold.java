import java.util.Arrays;

class Solution1219 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        // start from each point
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, backtrack(grid, i, j, 0));
            }
        }
        return max;
    }

    private int backtrack(int[][] grid, int row, int col, int sum) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[row].length)
            return sum;
        if (grid[row][col] == 0)
            return sum;

        int gold = grid[row][col];
        // mark as visited
        grid[row][col] = 0;

        // 4 directions
        int up = backtrack(grid, row + 1, col, sum + gold);
        int down = backtrack(grid, row - 1, col, sum + gold);
        int left = backtrack(grid, row, col - 1, sum + gold);
        int right = backtrack(grid, row, col + 1, sum + gold);

        // backtrack
        grid[row][col] = gold;

        // return the largest one of 4 directions
        return Arrays.asList(up, down, left, right).stream().max(Integer::compare).get();

    }
}