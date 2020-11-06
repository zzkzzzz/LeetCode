class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int id = 0;
        int count = 0;
        int target = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                target = nums[i];
                count = 0;
            }
            if (nums[i] == target && count < 2) {
                nums[id++] = nums[i];
                count++;
            }
        }
        return id;
    }
}