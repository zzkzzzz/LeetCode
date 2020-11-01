class Solution48 {
    public void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        // reverse up to down
        while (s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }

        // swap the symmetry
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}