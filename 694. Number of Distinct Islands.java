class Solution {
    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<List<int[]>> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                List<int[]> v = new ArrayList<>();
                helper(grid, i, j, i, j, v);
                res.add(v);
            }
        }
        return res.size();
    }

    // x and y are the base node, which are used for substraction
    private void helper(int[][] grid, int x, int y, int i, int j, List<int[]> v) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] <= 0) return;
        grid[i][j] *= -1;
        v.add(new int[]{i - x, j - y});
        for (int[] dir : dirs) {
            helper(grid, x, y, i + dir[0], j + dir[1], v);
        }
    }
}