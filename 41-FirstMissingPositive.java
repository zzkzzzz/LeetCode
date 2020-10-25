
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // use nums array itself, the ideal array should be {1,2,3,4}
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            // swap if nums[index] != index + 1
            while (curr - 1 >= 0 && curr - 1 < n && curr != nums[curr - 1]) {
                int next = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = next;
            }
        }

        for (int i = 0; i < n; i++) {
            // check if nums[index] == index + 1;
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1; // corner case: {1,2,3,4} return 5
    }
}