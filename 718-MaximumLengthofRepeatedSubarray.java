import java.util.Arrays;

class Solution718 {
    // space complexity=O(n)
    // time complexity=O(n*n)
    public int findLength(int[] A, int[] B) {
        int sizeA = A.length;
        int sizeB = B.length;
        // dp1 is previous dp array
        int[] dp1 = new int[Math.max(sizeA, sizeB)];
        // dp2 is current dp array
        int[] dp2 = new int[Math.max(sizeA, sizeB)];
        int max = 0;

        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                // append to previous subarray
                if (A[i] == B[j]) {
                    if (j == 0)
                        dp2[j] = 1;
                    else
                        dp2[j] = dp1[j - 1] + 1;

                    max = Math.max(max, dp2[j]);
                } else {
                    dp2[j] = 0;
                }

            }
            // update previous array dp1
            dp1 = dp2.clone();
        }
        return max;

    }

}