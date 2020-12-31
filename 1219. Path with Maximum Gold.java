// Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
// Output: 24
// Explanation:
// [[0,6,0],
//  [5,8,7],
//  [0,9,0]]
// Path to get the maximum gold, 9 -> 8 -> 7.
class Solution {
    private final int[] d = {0, 1, 0, -1, 0};

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                ans = Math.max(ans, dfs(grid, i, j, visited));
        return ans;
    }

    private int dfs(int[][] g, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0 || visited[i][j])
            return 0;
        visited[i][j] = true;        
        int mx = 0;
        for (int k = 0; k < 4; ++k)
            mx = Math.max(mx, g[i][j] + dfs(g, i + d[k], j + d[k + 1], visited));
        visited[i][j] = false;
        return mx;
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