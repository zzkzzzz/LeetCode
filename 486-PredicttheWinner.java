class Solution486 {
    // The problem is to predict whether player 1 is the winner
    // which can be think in a few ways
    // my approaches are
    // fisrt way: maximize player 1's sum check whether its larger than sum/2
    // second way: maximize player 1's sum check whether its larger than player 2's
    // The key point is that player 2 also need to make optimize move as player1
    // BUT is NOT to choose the bigger value from remaining array
    // Think about this example [2, 1, 100, 9]
    // If you are player 1, are you going to choose 9 ?

    // we have array num[i] to num[j],
    // If player 1 pick nums[i]
    // then for player 2, can pick from num[i+1] to num[j]
    // next turn, for player 1 can pick from
    // num[i+1+1] to num[j] OR num[i+1] to num[j-1]

    // If player 1 pick num[j]
    // then for player 2, can pick num[i] to num[j-1]
    // next turn, for player 1 can pick from
    // num[i+1] to num[j-1] OR num[i] to num[j-1-1]

    // Which one player 2 should pick?
    // Player 2 need to pick the can make he win
    // Leave the worst case to player 1

    // Then we summarize the formula
    // For player 1, which one to pick?
    // if pick num[i], then next one is
    // min(pick(i+2,j)+num[i],pick(i+1,j-1)+num[i])
    // if pick num[j], then next one is
    // min(pick(i+1,j-1)+num[j],pick(i,j-2)+num[j])
    // Finally, choose the better one btw these two cases
    // max(min(pick(i+2,j),pick(i+1,j-1)),min(pick(i+1,j-1),pick(i,j-2)))

    // Recrusive top-down solution
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        sum = (int) Math.ceil(sum / 2.0);

        return predictHelper(nums, 0, size - 1, sum);

    }

    public boolean predictHelper(int[] nums, int start, int end, int sum) {
        if (sum <= 0)
            return true;
        if (start > end)
            return false;

        // pick(i+2,j)&&pick(i+1,j-1)
        // means the worst case for player 1
        // (pick(i+2,j)&&pick(i+1,j-1))||(pick(i+1,j-1)&&pick(i,j-2))
        // get the better one between these two cases
        return (predictHelper(nums, start + 1 + 1, end, sum - nums[start])
                && predictHelper(nums, start + 1, end - 1, sum - nums[start]))
                || (predictHelper(nums, start + 1, end - 1, sum - nums[end])
                        && predictHelper(nums, start, end - 1 - 1, sum - nums[end]));
    }

    // Iterative bottom-up solution
    // Code is from the first comment of this post, but the idea is same
    // https://leetcode.com/problems/predict-the-winner/discuss/96828/JAVA-9-lines-DP-solution-easy-to-understand-with-improvement-to-O(N)-space-complexity.
    public boolean PredictTheWinner3(int[] nums) {
        int n = nums.length, sum = 0;
        // if the length of the array is even, player 1 always wins
        // It seems correct, but why?
        if (n % 2 == 0)
            return true;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
                int b = (i + 2 < n) ? dp[i + 2][j] : 0;
                int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
            }
        }

        return dp[0][n - 1] * 2 >= sum;
    }

    // Recursive bottom-up solution
    // maximize player 1's sum check whether its larger than player 2's
    public boolean PredictTheWinner2(int[] nums) {
        int size = nums.length;
        return predictHelper2(nums, 0, size - 1, 0, 0, 1);
    }

    public boolean predictHelper2(int[] nums, int start, int end, int sum1, int sum2, int player) {
        if (start > end)
            return sum1 >= sum2;
        else if (start == end) {
            if (player == 1) {
                return sum1 + nums[start] >= sum2;
            } else {
                return sum1 < nums[start] + sum2;
            }

        } else {
            // why use !predictHelper()?
            // because predictHelper() will return whether opponent is win or not
            // !predictHelper() means you will win or not
            if (player == 1) {
                return !predictHelper2(nums, start + 1, end, sum1 + nums[start], sum2, 2)
                        || !predictHelper2(nums, start, end - 1, sum1 + nums[end], sum2, 2);
            } else {
                return !predictHelper2(nums, start + 1, end, sum1, sum2 + nums[start], 1)
                        || !predictHelper2(nums, start, end - 1, sum1, sum2 + nums[end], 1);
            }
        }
    }
}