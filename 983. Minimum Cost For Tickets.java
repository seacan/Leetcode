// Input: days = [1,4,6,7,8,20], costs = [2,7,15]
// Output: 11
// Explanation: 
// For example, here is one way to buy passes that lets you travel your travel plan:
// On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
// On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
// On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
// In total you spent $11 and covered all the days of your travel.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] dayIncluded = new boolean[lastDay + 1];
        for (int day : days) dayIncluded[day] = true;
        int[] minCost = new int[lastDay + 1];
        minCost[0] = 0;
        for (int day = 1; day <= lastDay; ++day) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day - 1];
                continue;
            }
            int min;
            min = minCost[day - 1] + costs[0];
            min = Math.min(min, minCost[Math.max(0, day - 7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, day - 30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[lastDay];
    }
}