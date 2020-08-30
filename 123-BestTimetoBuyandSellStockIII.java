
/**
 * Given stock's prices for certain days and at most k transactions how to buy and sell
 * to maximize profit.
 *
 * Time complexity - O(number of transactions * number of days)
 * Space complexity - O(number of transcations * number of days)
 * 
 * The subproblem is = T[i][j]
 * = max((not transacting on jth day),(best you can get by transacting on jth day))
 * = max((T[i][j-1]),(T[i-1][m]+price[j]- prices[m])
 *                      m=0,1,2....j-1
 * 
 * T[i][j-1] is just previous days profit which means no transaction today
 * (T[i-1][m]+price[j]- prices[m])
 * On jth day you will do transactions, m means the day you buy the stock.
 * price[j]- prices[m] => means on day m you buy the stock, on the day j you sell the stock, the profit you earn
 * then how i know which day is "m"?
 * Need to compare each profits let m=0,1,2....j-1
 * max( (price[j]-price[0]),
 *      (price[j]-price[1])
 *      (price[j]-price[2])
 *      (price[j]-price[3])
 *       until...
 *      (price[j]-price[j-1]) )
 * then finally I will get the largest profit if we wanna sell on jth day 
 * it will cost one transaction, then we left i-1 transactions
 * T[i-1][m] => means if we wanna sell on mth day, the largest profit we can get
 * which will back to the original problem =>  T[i][j]
 * in the end until i-1 = 0, no transaction left
 * 
 * why think in this way?
 * can reference to LeetCode question 53 Maximum subarray which got similar idea
 * Both think in backwards, the day we sell stock... the last index of the array
 * then think in forward.....
 * 
 * Reference:
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/StockBuySellKTransactions.java
 * https://www.youtube.com/watch?v=oDhu5uGq_ic&feature=youtu.be
 * 
 */
import java.util.Deque;
import java.util.LinkedList;

class Solution123 {
    /**
     * This is faster method which does optimization on slower method Time
     * complexity here is O(K * number of days)
     *
     * Formula is T[i][j] = max(T[i][j-1], prices[j] + maxDiff) maxDiff =
     * max(maxDiff, T[i-1][j] - prices[j])
     */

    // How this thing works
    // k = 2// (i.e. maximum 2 transactions)
    // T[2, 0] = 0 // first day no profit to be made

    // T[2, 1] = max{
    // T[2, 0],
    // prices[1] + max(T[1, 0] - prices[0])
    // }

    // T[2, 2] = max{
    // T[2, 1],
    // max {
    // prices[2] + T[1, 0] - prices[0], // Repeated
    // prices[2] + T[1, 1] - prices[1]
    // }

    // T[2, 3] = max{
    // T[2, 2],
    // max {
    // prices[3] + max(T[1, 0] - prices[0],// Repeated
    // prices[3] + max(T[1, 1] - prices[1],// Repeated
    // prices[3] + max(T[1, 2] - prices[2])
    // }
    // }

    // T[2, 4] = max{
    // T[2, 3],
    // max {
    // prices[4] + T[1, 0] - prices[0],// Repeated
    // prices[4] + T[1, 1] - prices[1],// Repeated
    // prices[4] + T[1, 2] - prices[2],// Repeated
    // prices[4] + T[1, 3] - prices[3]
    // }
    // }

    // T[2, 5] = max{
    // T[2, 4],
    // max {
    // prices[5] + T[1, 0] - prices[0],// Repeated
    // prices[5] + T[1, 1] - prices[1],// Repeated
    // prices[5] + T[1, 2] - prices[2],// Repeated
    // prices[5] + T[1, 3] - prices[3],// Repeated
    // prices[5] + T[1, 4] - prices[4]
    // }
    // }

    public int maxProfit(int prices[], int k) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[k + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }
        printActualSolution(T, prices);
        return T[k][prices.length - 1];
    }

    /**
     * This is slow method but easier to understand. Time complexity is O(k * number
     * of days ^ 2) T[i][j] = max(T[i][j-1], max(prices[j] - prices[m] + T[i-1][m]))
     * where m is 0...j-1
     */

    public int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K + 1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i - 1][m]);
                }
                T[i][j] = Math.max(T[i][j - 1], maxVal);
            }
        }
        printActualSolution(T, prices);
        return T[K][prices.length - 1];
    }

    public void printActualSolution(int T[][], int prices[]) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j - 1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (T[i - 1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }

    }
}