class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // (1) new array;
        // extra space O(n)
        // int[] oldNums = nums.clone();
        // for (int i = 0; i < nums.length; i++) {
        // nums[(i + k) % nums.length] = oldNums[i];
        // }

        // (2) reverse 3 times
        // nums = "----->-->"; k =3
        // result = "-->----->";
        // reverse "----->-->" to "<--<-----"
        // reverse "<--" to "--><-----"
        // reverse "<-----" to "-->----->"
        // reverse(nums, 0, nums.length-1);
        // reverse(nums, 0, k-1);
        // reverse(nums, k, nums.length-1);

        // (3) move k times
        // 1->[7, 1, 2, 3, 4, 5, 6]
        // 2->[6, 7, 1, 2, 3, 4, 5]
        // 3->[5, 6, 7, 1, 2, 3, 4]
        while (k-- > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}