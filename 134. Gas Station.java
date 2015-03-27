public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, totalGas = 0, totalCost = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += (gas[i] - cost[i]);
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return totalCost > totalGas ? -1 : start;
    }
}