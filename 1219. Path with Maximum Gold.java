// Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
// Output: 24
// Explanation:
// [[0,6,0],
//  [5,8,7],
//  [0,9,0]]
// Path to get the maximum gold, 9 -> 8 -> 7.
class Solution {
    private static final int[] d = {0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                ans = Math.max(ans, dfs(grid, i, j, new HashSet<Integer>()));
        return ans;
    }

    private int dfs(int[][] g, int i, int j, Set<Integer> seen) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0 || !seen.add(i * g[0].length + j))
            return 0;
        int cur = g[i][j];
        int mx = 0;
        for (int k = 0; k < 4; ++k)
            mx = Math.max(mx, dfs(g, i + d[k], j + d[k + 1], seen));
        seen.remove(i * g[0].length + j);
        return cur + mx;
    }
}