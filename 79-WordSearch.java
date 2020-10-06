class Solution79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] arr = word.toCharArray();

        // find the character that match the word[0]
        // then start backtracking to find the rest
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, arr, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int index, int row, int col) {
        if (index == word.length)
            return true;

        if (row < 0 || col < 0 || row == board.length || col == board[row].length)
            return false;

        if (board[row][col] != word[index])
            return false;

        // mark visited characters
        // each character can only use once
        board[row][col] = '*';

        // boolean result1 = backtrack(board, word, index + 1, row - 1, col);
        // boolean result2 = backtrack(board, word, index + 1, row + 1, col);
        // boolean result3 = backtrack(board, word, index + 1, row, col - 1);
        // boolean result4 = backtrack(board, word, index + 1, row, col + 1);
        // return result1 || result2 || result3 || result4;

        // the difference between the following code and above code
        // if use previous code, initialize each recursion result and return
        // which will got Time Limir Exceed
        // because above code will wait to execute all the path then return

        // if use the code below, it will return true once any path returns ture
        // and will not execute the rest

        boolean result = backtrack(board, word, index + 1, row - 1, col)
                || backtrack(board, word, index + 1, row + 1, col) || backtrack(board, word, index + 1, row, col - 1)
                || backtrack(board, word, index + 1, row, col + 1);

        // change back the character once finish
        board[row][col] = word[index];

        return result;
    }

    private static boolean test(int n, char a) {
        for (int i = 0; i < n; i++) {
            System.out.println(a + " " + i + "\n");
            if (i != 0 && i % 13 == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = test(18, 'a') || test(6, 'b');
        System.out.println(result);
    }
}