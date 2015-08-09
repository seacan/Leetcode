// Solution 1: recursive solution
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrixHelper(matrix, 1, 0, n - 1);
        return matrix;
    }

    private void generateMatrixHelper(int[][] m, int num, int start, int end) {
        if (start > end) return;
        if (start == end) {
            m[start][end] = num;
            return;
        }

        for (int i = start; i <= end; i++) m[start][i] = num++;
        for (int i = start + 1; i <= end; i++) m[i][end] = num++;
        for (int i = end - 1; i >= start; i--) m[end][i] = num++;
        for (int i = end - 1; i >= start + 1; i--) m[i][start] = num++;
        generateMatrixHelper(m, num, start + 1, end - 1);
    }
}

// Solution 2: iterative solution
public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrixHelper(matrix, n);
        return matrix;
    }

    private void generateMatrixHelper(int[][] m, int n) {
        int num = 1;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i <= n - 1 - layer; i++) m[layer][i] = num++;
            for (int i = layer + 1; i <= n - 1 - layer; i++) m[i][n - 1 - layer] = num++;
            for (int i = n - 1 - layer - 1; i >= layer; i--) m[n - 1 - layer][i] = num++;
            for (int i = n - 1 - layer - 1; i >= layer + 1; i--) m[i][layer] = num++;
        }
        if (n % 2 == 1) m[n / 2][n / 2] = num;
    }