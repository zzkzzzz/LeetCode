import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution216 {
    // backtracking
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        backtrack(result, new ArrayList<>(), nums, n, k, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remaining, int size,
            int start) {
        if (tempList.size() > size)
            return;
        if (remaining < 0)
            return;
        if (tempList.size() == size && remaining == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remaining - nums[i], size, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}