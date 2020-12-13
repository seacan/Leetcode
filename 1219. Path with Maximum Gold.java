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
        seen.remove(i * g[0].length + j);  // Do not forget to remove.
        return cur + mx;
    }
}

class Solution {
    private final int[] d = {0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j) {
                Set<Integer> visited = new HashSet<Integer>();
                visited.add(i * grid[0].length + j);
                ans = Math.max(ans, dfs(grid, i, j, visited));
            }
        return ans;
    }

    private int dfs(int[][] g, int i, int j, Set<Integer> visited) {
        int cur = g[i][j], max = 0;
        for (int k = 0; k < 4; ++k) {
            int newI = i + d[k], newJ = j + d[k + 1];
            if (newI >= 0 && newI < g.length && newJ >= 0 && newJ < g[0].length &&
                    g[newI][newJ] != 0 && !visited.contains(newI * g[0].length + newJ)) {
                visited.add(newI * g[0].length + newJ);
                max = Math.max(max, dfs(g, newI, newJ, visited));
                visited.remove(newI * g[0].length + newJ);
            }
        }
        return cur + max;
    }
}