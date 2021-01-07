class Solution1011 {

    // binary search - find left boundary
    int shipWithinDays(int[] weights, int D) {
        // min weight capacity
        int left = getMax(weights);
        // max weight capacity + 1
        int right = getSum(weights) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // whether the package can be shiped with D days when the capacity is cap
    boolean canFinish(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }

    int getMax(int[] weights) {
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max)
                max = weights[i];
        }
        return max;
    }

    int getSum(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum = sum + weights[i];
        }
        return sum;
    }
}