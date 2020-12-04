import java.util.Arrays;

class Solution136 {
    public int singleNumber(int[] nums) {
        // 1^1=0 2^2=0
        // 1^1^2=2
        // 2^2^9=9
        return Arrays.stream(nums).reduce(0, (i, j) -> i ^ j);
    }
}