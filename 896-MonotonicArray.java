class Solution896 {
    public boolean isMonotonic(int[] A) {
        int res = 0;
        int equal = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                res++;
            else if (A[i] < A[i - 1])
                res--;
            else
                equal++;
        }
        return res + equal + 1 == A.length || -res + equal + 1 == A.length;
    }
}