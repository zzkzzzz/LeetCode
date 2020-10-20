class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // insert at the end of nums1[] since from nums1[m] to nums1[m+n] is empty
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }

        // Copy remaining elements of nums2[] if any
        // if nums1[] got any remaining elements no need copy over, just leave there,
        // bcs its already sorted
        while (j >= 0)
            nums1[k--] = nums2[j--];

    }
}