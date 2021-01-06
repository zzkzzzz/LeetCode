class Solution69 {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;

        int left = 1;
        int right = x / 2;

        while (left <= right) {
            // prevent the integer overflow
            int mid = left + (right - left) / 2;

            // prevent the integer overflow
            // mid>x/mid instead of mid*mid>x
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                left = mid + 1;
            else if (mid > x / mid)
                right = mid - 1;
        }

        return right;
    }
}