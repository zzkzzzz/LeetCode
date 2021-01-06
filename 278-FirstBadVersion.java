/* The isBadVersion API is defined in the parent class VersionControl.
     */

class Solution278 {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else if (!isBadVersion(mid)) {
                left = mid + 1;
            }
        }
        return left;

    }

    public int firstBadVersion2(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}