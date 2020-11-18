import java.util.Stack;

class Solution962 {
    // time complexity=O(n^2)
    public int maxWidthRamp(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] < A[i - 1]) {
                for (int j = A.length - 1; j > i - 1 + max; j--) {
                    if (j >= 0 && i < j && A[i] <= A[j]) {
                        max = Math.max(max, j - i);
                        break;
                    }
                }
            }
        }
        return max;
    }

    public int maxWidthRamp2(int[] A) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = A.length;
        // Keep a decraesing stack.
        for (int i = 0; i < n; ++i)
            if (s.empty() || A[s.peek()] > A[i])
                s.add(i);
        // start from last element of A
        for (int i = n - 1; i > res; --i)
            // the first A[s.peek()] is gunrated that is smaller or equal to A[i]
            // then s.pop() to avoid duplicate calculattion
            // bcs if A[i-1] >= A[s.peek()]
            // width: i-1-s.peek() < i-s.peek()
            // which confirmed that the A[i-1] is unnecessary to compare with A[s.peek()]
            // so pop out the top one
            while (!s.empty() && A[s.peek()] <= A[i])
                res = Math.max(res, i - s.pop());
        return res;
    }
}