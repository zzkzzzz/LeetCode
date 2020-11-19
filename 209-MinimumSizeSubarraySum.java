class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        // [2,3,1,2,4,3]]
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                min = Math.min(i - start + 1, min);
                sum = sum - nums[start];
                start++;

            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
