class Solution122 {
    // subproblem=profit earn previous days + pofit earned today
    // profit = prices[i]-min
    public int maxProfit(int[] prices) {
        int sum = 0;
        if (prices.length == 0)
            return sum;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // if today's price lower cant earn profit
            // then min price will be today's price
            if (prices[i] < min)
                min = prices[i];
            // if today's price increase/ higher than min price (can be equal)
            // then can earn profit, accumlate to sum
            // set min price to today's price
            // e.g [5,2,4,6]
            // 2<5 min=2
            // 4>2 profit1=4-2=2 min=4
            // 6>3 profit2=6-4=2 min=6
            // sum=profit1+profit2=4
            // equals=> 6-2=4
            // profit today= profit of previous day + today's price-previous day's price
            else {
                sum = sum + prices[i] - min;
                min = prices[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution122 solution = new Solution122();
        System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
