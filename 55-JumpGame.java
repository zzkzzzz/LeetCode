class Solution55 {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        int i = 1;
        while (i < nums.length) {
            count = Math.max(--count, nums[i]);
            if (count <= 0 && i < nums.length - 1 || nums[0] == 0)
                return false;
            i++;
        }
        return true;
    }

}