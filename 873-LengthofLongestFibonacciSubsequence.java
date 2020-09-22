import java.util.HashMap;

class Solution873 {

    // To find the longest of length Fib Sequence
    // A fib sequence should like this: A[j] - A[i], A[i], A[j], A[i] + A[j]
    // sum = A[i] + A[j]
    // diff = A[j] - A[i]
    // if we find out that sum exists in the A[]
    // then (A[i], A[j], sum) is a fib sequence
    // if diff also exists in the A[]
    // then (diff, A[i], A[j]) is a fib sequence
    // So the length of the Fib Sequence from 0 to i is
    // 1 + previous length of the Fib Sequence from 0 to diff
    // dp[i][j] = 1 + dp[indexOf(diff)][i]
    // Finally, return max+2 because we didn't count A[j] and sum into max

    public int lenLongestFibSubseq(int[] A) {
        int size = A.length;
        // Hashmap to store the numbers and index of the numbers
        HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++)
            nums.put(A[i], i);
        int[][] dp = new int[size][size];
        int sum = 0;
        int diff = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                sum = A[i] + A[j];
                diff = A[j] - A[i];
                if (nums.containsKey(sum)) {
                    if (nums.containsKey(diff) && diff < A[i])
                        dp[i][j] = 1 + dp[nums.get(diff)][i];
                    else
                        dp[i][j] = 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max > 0 ? max + 2 : 0;
    }
}