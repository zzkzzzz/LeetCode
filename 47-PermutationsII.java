import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution47 {
    // backtracking
    // reference
    // https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    // extra boolean[] to tarck the used number
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // condition 1: if the number used before (used[i])
                // condition 2: when a number has the same value with its previous, we can use
                // this number only if his previous is used
                // when going to use a number num[i]
                // there is a number num[i-1] => nums[i] == nums[i - 1]
                // which will result in same permutation
                // however nums[i-1] must not used before =>!used[i - 1]
                // bcs when nums[i-1] is used and not fulfill any condition above
                // which means nums[i-1] is the first time to used
                // For example [1,1,3]
                // when use the first "1" nums[0] as the first num
                // we can have [1,1,3] [nums[0],nums[1],nums[2]]
                // however, when we loop to nums[1], nums[1] == nums[0]
                // used[0]==ture, which means this is first time use "1"
                // but when we use second "1" nums[1] as the first num
                // we can have [1,1,3] [nums[1],nums[0],nums[2]] which is repeated
                // nums[1] == nums[0] and used[0]==false and i=1>0
                // Then we will not use this nums[i], continue the loop
                // reference: https://ibb.co/Sw0fgk5

                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}