class Solution695 {
    // dfs
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }
        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + helper(grid, i + 1, j) + helper(grid, i - 1, j) + helper(grid, i, j - 1)
                    + helper(grid, i, j + 1);
        }
        return 0;
    }
}