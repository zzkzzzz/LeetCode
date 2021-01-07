class Solution875 {
    // O(NlogN)
    public int minEatingSpeed(int[] piles, int H) {
        // get max piles value
        int left = 1;
        int right = getMax(piles);
        while (left <= right) {
            // prevent overflow
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // O(n)
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    // O(n)
    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles)
            max = Math.max(n, max);
        return max;
    }
}