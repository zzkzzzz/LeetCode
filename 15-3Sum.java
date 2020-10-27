import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

class Solution15 {
    // TLE
    // backtracking
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length == 0 || nums.length == 1 || nums.length == 2 || nums[0] > 0)
            return list;

        for (int i = 0; i < nums.length - 2; i++) {
            // repeated num
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            backtrack(set, new ArrayList<>(Arrays.asList(nums[i])), nums, nums[i], i + 1, 1);
        }

        list.addAll(set);
        return list;
    }

    private void backtrack(Set<List<Integer>> set, List<Integer> tempList, int[] nums, int remain, int start,
            int count) {
        if (remain == 0 && count == 3)
            set.add(new ArrayList<>(tempList));
        else if (count >= 3)
            return;
        else {
            for (int i = start; i < nums.length; i++) {
                // repeated num
                if (i > start && nums[i] == nums[i - 1] && !tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                count++;
                backtrack(set, tempList, nums, remain + nums[i], i + 1, count);
                tempList.remove(tempList.size() - 1);
                count--;
            }
        }

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0 || nums.length == 1 || nums.length == 2 || nums[0] > 0)
            return res;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
}