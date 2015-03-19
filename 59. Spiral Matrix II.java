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