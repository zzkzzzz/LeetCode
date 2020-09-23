import java.util.Arrays;

class Solution698 {
    // Backtracking Solution
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum % k != 0 || k <= 0)
            return false;
        Arrays.sort(nums);
        int target = sum / k;
        int[] visited = new int[nums.length];

        return canPartition(nums, visited, 0, k, 0, 0, target);

    }

    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num,
            int target) {
        // no need calculate the rest elements bcs the sum definitely equal to target
        if (k == 1)
            return true;
        // if cur_sum larger than target
        if (cur_sum > target)
            return false;
        // corner case: targer=0
        // must make sure there are numbers has been selected
        if (cur_sum == target && cur_num > 0)
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        for (int i = start_index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (canPartition(nums, visited, i + 1, k, cur_sum + nums[i], cur_num++, target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}