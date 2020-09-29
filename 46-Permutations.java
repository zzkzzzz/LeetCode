import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution46 {
    // backtracking
    // reference
    // https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                // if the number used before
                // then pass it
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}