class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // the number of changes
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                // if nums[i-1]>nums[i], its risky to change nums[i] to nums[i-1]
                // bcs the nums[i+1] may affect from that
                // so change nums[i-1] to nums[i] is safer
                // for example: 5 7 6 6
                // modified => 5 6 6 6
                // However, if nums[i-2] > nums[i]
                // the only choice is to change nums[i] to nums[i-1]
                // for example; 6 7 1
                // modified => 6 7 7
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i]; // modify nums[i-1] of a priority
                else
                    nums[i] = nums[i - 1]; // have to modify nums[i]
            }
        }
        return count <= 1;
    }
}