class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i > k - 1)
                sum -= nums[i - k];
            if (i >= k - 1)
                max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}