class Solution121 {
    // time complexity=O(n^2)
    // space complexity=O(1)
    // brute force list out all possible result
    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }

    // time complexity=O(n)
    // space complexity=O(1)
    // subprblem =
    // profit from previous days, or
    // profit gained on this day (current price - minimum price before)
    // Dymamic programming: the minimum price is dynamic changing
    // so one variable needed for memorization
    public int maxProfit_2(int[] prices) {
        int max = 0;
        if (prices.length == 0)
            return max;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution121 solution = new Solution121();
        System.out.println(solution.maxProfit_2(new int[] { 7, 6, 5, 4, 3, 9 }));
    }
}
