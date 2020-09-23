class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length, k = days[0].length;
        int[][] memo = new int[n][k];
        return helper(flights, days, 0, 0, memo);
    }

    private int helper(int[][] flights, int[][] days, int city, int day, int[][] memo) {
        int n = flights.length, k = days[0].length, res = 0;
        if (day == k) return 0;
        if (memo[city][day] > 0) return memo[city][day];
        for (int i = 0; i < n; i++)
            if (i == city || flights[city][i] == 1)
                res = Math.max(res, days[i][day] + helper(flights, days, i, day + 1, memo));
        memo[city][day] = res;
        return memo[city][day];
    }
}