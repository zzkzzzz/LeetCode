class Solution35 {
    // linear search
    // time complexity=O(n)
    public int searchInsert(int[] nums, int target) {
        if (target == 0)
            return 0;

        if (nums.length == 1)
            return nums[0] >= target ? 0 : 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] > target)
                return i + 1;
            else if (nums[i] >= target)
                return i;
        }

        return nums[nums.length - 1] == target ? nums.length - 1 : nums.length;
    }

    // Binary search
    // Search a sorted array by repeatedly dividing the search interval in half.
    // time complexity=O(Log n)
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}