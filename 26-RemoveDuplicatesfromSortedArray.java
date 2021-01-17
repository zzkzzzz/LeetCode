class Solution26 {
    public int removeDuplicates(int[] nums) {
        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            // if its not a duplicate number, update the array with id+1
            // so next iteration will compare with this new number nums[id++]
            // As question metioned no need remove the number, it only requires the length
            // of the array
            if (nums[i] != nums[i - 1])
                nums[id++] = nums[i];
        }
        return id;
    }

    int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}