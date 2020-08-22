// brute force approach to get all subarrays
// it will get TLE 
// space complexity and time complexity will be very big as nums.length grows
class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < (nums.length - i); j++) {
                if (j == 0)
                    dp[i][0] = nums[i];
                else
                    dp[i][j] = dp[i][j - 1] + nums[j + i];
                max = Math.max(max, dp[i][j]);

            }
        }

        return max;

    }

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        System.out.println(solution.maxSubArray(new int[] { -1 }));
    }

}

// Dynamic programming
// subproblem should be =
// maxSubArray(A, i)=
// maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];

class Solution53_2 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        // loop over nums array
        // nums[i] will be the end of the maxSubArray
        // if the sum before nums[i] is negative, then there is no point to add them
        // so A[i] will be the new start of the maxSubArray
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution53_2 solution = new Solution53_2();
        System.out.println(solution.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

}