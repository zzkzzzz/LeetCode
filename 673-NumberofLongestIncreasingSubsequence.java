import java.util.Arrays;

class Solution673 {
    // time complexity=O(n^2)
    // space complexity=O(n)
    // this solution is base on 300.LongestIncreasingSubsequence
    // which just add one array dynamically store the count
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // dp[i] to store the longest length until nums[i]
        int[] dp = new int[nums.length];
        // count[i] to store the count of longest length until nums[i]
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int longestLength = 1;
        int countLongest = 1;

        // if nums[i] is end of the array (start from nums[1])
        for (int i = 1; i < nums.length; i++) {
            // num[j] is from num[0] to num[i-1]
            for (int j = 0; j < i; j++) {
                // if the current element(num[i]) is greater than the previous element(nums[j]),
                // we can safely add 1 to the value of previous max length(dp[j]+1).
                // Since the previous max length was also calculated in a similar manner
                if (nums[i] > nums[j]) {
                    // if this longest length already calculated before
                    if (dp[i] == dp[j] + 1)
                        count[i] = count[i] + count[j];
                    // if have a longer length, update the dp[i]
                    // bcs we just append nums[i] to previous subsequences
                    // count[i] will be still same as count[j]
                    else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }

                }
            }
            // if the longest length for this nums[i] remain same
            if (longestLength == dp[i])
                countLongest = countLongest + count[i];
            // update the longest length and count of longest length
            if (longestLength < dp[i]) {
                longestLength = dp[i];
                countLongest = count[i];
            }

        }
        return countLongest;

    }
}