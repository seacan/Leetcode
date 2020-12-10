public class Solution {
    private final int[][] skip = new int[10][10];

    public int numberOfPatterns(int m, int n) {
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;

        int result = 0;
        boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {
            result += dfs(1, visited, i - 1) * 4;
            result += dfs(2, visited, i - 1) * 4;
            result += dfs(5, visited, i - 1);
        }
        return result;
    }

    public int dfs(int curr, boolean[] visited, int remain) {
        if (remain == 0) return 1;

        int result = 0;
        visited[curr] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = skip[curr][next];
            if (!visited[next] && (jump == 0 || visited[jump]))
                result += dfs(next, visited, remain - 1);
        }
        visited[curr] = false;
        return result;
    }
}