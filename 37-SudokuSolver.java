class Solution37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);

    }

    private boolean backtrack(char[][] board, int row, int col) {
        // reach the last column, next row
        if (col == 9)
            return backtrack(board, row + 1, 0);

        // reach the last row, finish
        if (row == 9)
            return true;

        // preset number, skip
        if (board[row][col] != '.')
            return backtrack(board, row, col + 1);

        // try number 1-9
        for (char k = '1'; k <= '9'; k++) {
            // check confict with row, col and 3*3 block
            if (check(board, row, col, k)) {
                board[row][col] = (char) k;
                if (backtrack(board, row, col + 1))
                    return true;
                // not working, backtrack, try next number
                board[row][col] = '.';
            }
        }
        // 1-9 all fail
        return false;

    }

    private boolean check(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[i][col] == num)
                return false;
            // check column
            if (board[row][i] == num)
                return false;
            // check 3*3 block
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num)
                return false;
        }
        return true;
    }

}