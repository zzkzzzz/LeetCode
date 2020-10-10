import java.util.Arrays;

class Solution1219 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, backtrack(grid, i, j, 0, visited));
            }
        }
        return max;
    }

    private int backtrack(int[][] grid, int row, int col, int sum, boolean[][] visited) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[row].length)
            return sum;
        if (grid[row][col] == 0)
            return sum;
        if (visited[row][col])
            return sum;

        visited[row][col] = true;

        int up = backtrack(grid, row + 1, col, sum + grid[row][col], visited);
        int down = backtrack(grid, row - 1, col, sum + grid[row][col], visited);
        int left = backtrack(grid, row, col - 1, sum + grid[row][col], visited);
        int right = backtrack(grid, row, col + 1, sum + grid[row][col], visited);

        visited[row][col] = false;

        return Arrays.asList(up, down, left, right).stream().max(Integer::compare).get();

    }
}