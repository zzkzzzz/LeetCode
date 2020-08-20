
/** 
 * fewest number of coins that you need to make up that amount.
 * subprblems = fewest number of using all but the first kind of coin, 
 * plus fewest number of to change amount a - d using all n
 * kinds of coins, where d is the denomination of the first kind of coin.
 * 
 * recursion => topdown solution
 * However will got TLE 
 * //TODO:how to do Memoization?
 * tried but not working
 * 
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 */
import java.util.Arrays;

class Solution322 {
    public int coinChange(int[] coins, int amount) {
        Integer[] ways = new Integer[amount + 1];
        int min = count(amount, coins, coins.length, 0, ways);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int count(int amount, int[] coins, int length, int count, Integer[] ways) {

        if (amount == 0)
            return count;
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (length <= 0)
            return Integer.MAX_VALUE;
        // if (ways[amount] != null) {
        // return ways[amount];
        // }
        int way1 = count(amount, coins, length - 1, count, ways);
        int way2 = count(amount - coins[length - 1], coins, length, count + 1, ways);
        int min = Math.min(way1, way2);
        // System.out.println(min);
        System.out.println(count);
        ways[amount] = ways[amount] == null ? min : Math.min(ways[amount], min);
        System.out.println(Arrays.toString(ways));

        return ways[amount];
    }

    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int sum = 11;

        Solution322 solution = new Solution322();
        System.out.println(
                "At least " + solution.coinChange(coins, sum) + " coins are required to make a value of " + sum);
    }
}

// (Dynamic programming - Top down)
// cut the partial solutions in the recursive tree
class Solution322_2 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (count[rem - 1] != 0)
            return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}

// (Dynamic programming - Bottom up)
class Solution322_3 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // loop through all the values from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // loop through all coins to find out the minimum value
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // dp[i - coins[j] => subproblem
                    // F(3)=min{F(3−c1),F(3−c2),F(3−c3}+1
                    // =min{F(3−1),F(3−2),F(3−3)}+1
                    // =min{F(2),F(1),F(0)}+1
                    // =min{1,1,0}+1
                    // =1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}