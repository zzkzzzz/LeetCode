import java.util.Arrays;

class Solution561 {
    // if we consider ai<=bi for all pairs
    // Sum(a) => sum of a1 to an
    // Sum(b) => sum of b1 to bn
    // In order to find the maximum Sum(a) then Sum(b) must be minimum
    // Sum(a) + Sum(b) = Sum(a+b)
    // if we can make the Sum(b)-Sum(a) as minimum as possible(approach to 0)
    // Sum(a) will be maximum
    // Then we can let the bi-ai as minimum as possible
    // the two adjacent numbers in sorted array will result in minimum difference

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}