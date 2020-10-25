import java.util.List;
import java.util.ArrayList;

class Solution448 {
    // use negative number to mark the visited index without changing the meaning of
    // the item. Math.abs(nums[i]) will return the origin number.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // set index to negative for each number
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            nums[x - 1] = -Math.abs(nums[x - 1]);
        }

        // any index with positive number is missing
        List<Integer> missing = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }

        return missing;
    }
}