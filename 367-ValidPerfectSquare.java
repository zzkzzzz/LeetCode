class Solution367 {
    // time complexity is O(log(n))
    public boolean isPerfectSquare(int num) {
        if (num <= 1)
            return true;

        int left = 1;
        int right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = (int) mid + 1;
            else if (mid * mid > num)
                right = (int) mid - 1;
        }

        return false;

    }

    // math solution
    // A square number is 1+3+5+7+...
    // time complexity is O(sqrt(n))
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}