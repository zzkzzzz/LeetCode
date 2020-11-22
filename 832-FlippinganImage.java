class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        // if the values are not the same,
        // but you swap and flip, nothing will change.
        // So if they are same, we toggle both, otherwise we do nothing.
        // https://leetcode.com/problems/flipping-an-image/discuss/130590/C%2B%2BJavaPython-Reverse-and-Toggle
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1])
                    row[i] = row[n - i - 1] ^= 1;
        return A;
    }
}