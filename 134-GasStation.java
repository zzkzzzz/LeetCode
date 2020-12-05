import java.util.Arrays;

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();
        if (totalGas < totalCost)
            return -1;

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i])
                continue;

            if (circuitTest(gas, cost, i))
                return i;
        }

        return -1;
    }

    private boolean circuitTest(int[] gas, int[] cost, int i) {
        int sum = 0;

        for (int j = i; j < i + gas.length; j++) {
            int index = j % gas.length;
            sum = sum + gas[index];
            if (sum >= cost[index])
                sum = sum - cost[index];
            else
                return false;
        }

        return true;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        // determine if we have a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out where to start
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

}