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
}