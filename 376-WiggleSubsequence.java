// e.g. [7,5,3,8,6,7]
// if start with decreasing wiggle => [7,5,8,6,7]
// if start with increasing wiggle => [7,8,6,7]
// the the subproblem is to find the longer length between these two
class Solution376 {
    // recursive top-bottom
    // time complexity O(n)
    // space complexity O(1)
    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0)
            return 0;
        // let the first difference of the wiggle is positive
        // e.g [7,5,8] diff=7-5=2 positive
        int positivelength = positiveStart(nums, 0, 1);

        // let the first difference of the wiggle is negative
        // e.g [7,5,8]
        // diff1=7-5=2 positive (x)
        // diff2=5-8=-3 negative
        int negativelength = negativeStart(nums, 0, 1);

        return Math.max(positivelength, negativelength);
    }

    private int positiveStart(int[] nums, int index, int length) {
        int max = 0;
        if (index + 1 == nums.length)
            return length;
        // if find the positive difference
        // then next difference should be neagtive
        if (nums[index] > nums[index + 1])
            max = this.negativeStart(nums, index + 1, length + 1);
        // if the difference is not positive
        // then keep find until find a positive difference
        else if (nums[index] <= nums[index + 1])
            max = this.positiveStart(nums, index + 1, length);

        return max;

    }

    private int negativeStart(int[] nums, int index, int length) {
        int max = 0;
        if (index + 1 == nums.length)
            return length;
        if (nums[index] < nums[index + 1])
            max = this.positiveStart(nums, index + 1, length + 1);
        else if (nums[index] >= nums[index + 1])
            max = this.negativeStart(nums, index + 1, length);
        return max;
    }

}