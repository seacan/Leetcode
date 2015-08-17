public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            count[i][0] = matrix[i][0] == '0' ? 0 : 1;
            res = Math.max(res, count[i][0]);
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = matrix[0][i] == '0' ? 0 : 1;
            res = Math.max(res, count[0][i]);
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    count[i][j] = 0;
                    continue;
                }
                count[i][j] = Math.min(Math.min(count[i - 1][j - 1], count[i - 1][j]), count[i][j - 1]) + 1;
                res = Math.max(res, count[i][j]);
            }
        return res * res;
    }
}