class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        // corner case
        if (nums.length == 0)
            return new int[] { -1, -1 };

        // find the number through binary search
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                break;
            else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        // if the target not exists
        if (nums[mid] != target)
            return new int[] { -1, -1 };

        int first = mid;
        int last = mid;

        // find the starting position of target
        while (first > 0 && nums[first - 1] == target) {
            first--;
        }

        // find the ending position of target
        while (last < nums.length - 1 && nums[last + 1] == target) {
            last++;
        }

        return new int[] { first, last };
    }
}