class Solution11 {
    public int maxArea(int[] A) {
        // two pointer solution, take i as left pointer, j as right pointer
        // L as the length between i and j
        // 1. A[i] < A[j], Origin Area=L*A[i]
        // -> 1. move i to right
        // ->-> if A[i+1]>A[j], area=(L-1)*A[j]
        // ->-> if A[i+1]<A[j], area=(L-1)*A[i+1]
        // -> 2. move j to left (can't)
        // ->-> if A[i]<A[j-1], area=(L-1)*A[i]<L*A[i]
        // ->-> if A[i]>A[j-1], area=(L-1)*A[j-1]<L*A[i]
        // ->-> so move j left won't give larger area
        // 2. A[i] > A[j], Origin Area=L*A[j]
        // this will similar to previous analysis
        // -> 1. move i to right (can't)
        // -> 2. move j to left
        // ->-> if A[i]<A[j-1], area=(L-1)*A[i]
        // ->-> if A[i]>A[j-1], area=(L-1)*A[j-1]

        int area = 0;
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(A[i], A[j]));
            if (A[i] < A[j])
                i++;
            else
                j--;
        }
        return area;

    }
}