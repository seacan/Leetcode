public class Solution {
    class Pair {
        public int first;
        public int second;
        public Pair(int f, int s) {
            first = f;
            second = s;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    count++;
                    searchIsland(grid, i, j);
                }
        return count;
    }

    private void searchIsland(char[][] grid, int row, int col) {
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(row, col));
        while (!st.isEmpty()) {
            Pair cur = st.pop();
            grid[cur.first][cur.second] = '0';
            for (int i = 0; i < 4; i++) {
                int newRow = cur.first + x[i], newCol = cur.second + y[i];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1')
                    st.push(new Pair(newRow, newCol));
            }
        }
    }
}