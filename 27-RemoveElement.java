class Solution27 {
    public int removeElement(int[] nums, int val) {
        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[id++] = nums[i];
        }
        return id;
    }

    int removeElement2(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}