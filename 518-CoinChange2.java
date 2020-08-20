/**
 * subprblems = the number of ways to change amount a using all but the first
 * kind of coin, plus the number of ways to change amount a - d using all n
 * kinds of coins, where d is the denomination of the first kind of coin.
 * 
 * button up Tabulation methods is better in this question since all the states
 * wiil be used
 */

// Memoization methods => top down
class Solution518 {
    public int change(int amount, int[] coins) {
        Integer[][] ways = new Integer[coins.length + 1][amount + 1];
        return count(amount, coins, coins.length, ways);
    }

    private int count(int amount, int[] coins, int length, Integer[][] ways) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (length <= 0)
            return 0;
        if (ways[length][amount] != null)
            return ways[length][amount];

        int way1 = count(amount, coins, length - 1, ways);
        int way2 = count(amount - coins[length - 1], coins, length, ways);

        ways[length][amount] = way1 + way2;
        return way1 + way2;
    }
}

// Tabulation methods => button up
class Solution518_2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}

// Tabulation methods => button up => improved
class Solution518_2_2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
