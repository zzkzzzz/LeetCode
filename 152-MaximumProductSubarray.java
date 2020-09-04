class Solution152 {
    // brute force, memory limit exceeded
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int dp[][] = new int[length][length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (j == i)
                    dp[i][j] = nums[j];
                else
                    dp[i][j] = dp[i][j - 1] * nums[j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // optimizated space complexity to O(n)
    // but time complexity O(n^2)
    public int maxProduct2(int[] nums) {
        int length = nums.length;
        int dp[] = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (j == i)
                    dp[j] = nums[j];
                else
                    dp[j] = dp[j - 1] * nums[j];
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    // optimizated space complexity to O(1)
    // but time complexity O(n^2)
    public int maxProduct3(int[] nums) {
        int length = nums.length;
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (j == i)
                    dp = nums[j];
                else
                    dp = dp * nums[j];
                max = Math.max(max, dp);
            }
        }
        return max;
    }

    // reference:
    // https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
    // time complexity=O(n)
    // space complexity=O(1)
    // subproblem=
    // max product for the current number is either the current number itself
    // or the max/min by the previous number times the current one
    // if current one is negative, max times current one will become the min one

    // can relate to question 53 Maximum subarry which have the similar idea
    // the maximun subarray is either current number itself
    // or the sum by previous number plus current number
    // if the sum before current one is negative, then there is no point to add them
    // so current will be the new start of the maxSubArray
    public int maxProduct4(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // a bigger positive number multiplied by negative becomes smaller
            // a negative number multiplied by negative becomes larger
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

}