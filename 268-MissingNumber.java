class Solution268 {

    // Solution 1: SUM
    // Time complexity: O(n), Space complexity: O(1)
    // Sum up from 0 to n => SUM
    // the difference between the SUM and the sum of nums will be the missing Number
    public int missingNumber1(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }

    // Solution 2: XOR
    // Time complexity: O(n), Space complexity: O(1)
    // For XOR operation, two same numbers a^a will result in 0
    // So a^a^b=b
    // To find the missing numebr, result=result^i^nums[i]
    // in the end, the index i and nums[i] will cancel each other
    // and will left the missing num
    public int missingNumber2(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

}