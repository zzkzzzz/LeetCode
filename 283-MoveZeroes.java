class Solution283 {
    public void moveZeroes(int[] nums) {
        // use i to find zero
        // use j to find non-zero to swap the position
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            if (nums[i] != 0)
                i++;
            j++;
        }
    }
}