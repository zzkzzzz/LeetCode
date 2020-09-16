import java.util.Arrays;

class Solution279 {
    // find the least number of perfect square numbers which sum to n
    // which is exactly same as coin change problem (322)
    // find fewest number of coins that you need to make up that amount
    // now, the coins become square numbers

    // subproble: for a number n, if I take a square number into account, then
    // the least number of perfect square numbers which sum to n we can get is
    // 1+the least number of perfect square numbers which sum to (n-square number).
    // e.g, n=12
    // if we take 4(2*2) into sum
    // then we only need to find out
    // the least number of perfect square numbers which sum to 8
    // which is F(12)=1+F(12-4)=1+F(8)
    // However, there we also can choose 1 or 9 as our choice
    // Finally we can get the formula
    // F(12)=min{F(12−1),F(12−4),F(12−9)}+1
    // =min{F(11),F(8),F(3)}+1
    // =min{4,2,3}+1
    // =2+1
    // =3
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // get the nearest square number of n
        // e.g.
        // n=12 max=3 3*3=9<12 4*4=16>12
        // n=28 max=5 5*5=25<28 6*6=36>28
        int max = (int) Math.floor(Math.sqrt(n));
        // fill the array with n which is maximum number sum by 1
        Arrays.fill(dp, n);
        dp[0] = 0;
        // loop through all the values from 1 to n
        for (int i = 1; i <= n; i++) {
            // loop through all root to find out the minimum value
            for (int j = 1; j <= max; j++) {
                if (j * j <= i) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n] > n ? -1 : dp[n];
    }
}
