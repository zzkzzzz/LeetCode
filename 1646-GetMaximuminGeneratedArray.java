class Solution1646 {
    // time complexity= O(n)
    // space complexity= O(n)
    public int getMaximumGenerated(int n) {
        // corner case
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] nums = new int[n + 1];
        int max = 1;
        nums[0] = 0;
        nums[1] = 1;

        // start from nums[2]
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0)
                nums[i] = nums[i / 2];// nums[2 * i] = nums[i]
            else
                nums[i] = nums[i / 2] + nums[i / 2 + 1]; // nums[2 * i + 1] = nums[i] + nums[i + 1]

            max = Math.max(max, nums[i]);
        }

        return max;
    }

}