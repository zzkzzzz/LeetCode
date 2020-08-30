// basically is same as 198 House Robber, but add in one restriction
// fisrt and last one are connected, which means can not rob first one and last one tgt
// then we can break this into subproblem
// we rob first one and we don't rob first one, we only need to choose the larger one btw them
// if we rob first one, we can't rob last one=>  rob(0,n-2)
// if we  don't rob first one, then we can rob last one, => rob(1,n-1)
// subproblem= max(rob(0,n-2),rob(1,n-1))

class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(rob_helper(nums, 0, n - 2), rob_helper(nums, 1, n - 1));
    }

    public int rob_helper(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}