public class Solution {
    private int total = 0;
    public int totalNQueens(int n) {
        int[] sol = new int[n];
        totalNQueensHelper(0, n, sol);
        return total;
    }

    private void totalNQueensHelper(int index, int n, int[] sol) {
        if (index == n) {
            total++;
            return;
        }

        for (int i = 0; i < n; i++)
            if (canFitAt(index, i, sol)) {
                sol[index] = i;
                totalNQueensHelper(index + 1, n, sol);
                sol[index] = 0;
            }
    }

    private boolean canFitAt(int index, int col, int[] sol) {
        for (int i = 0; i < index; i++) {
            if (sol[i] == col) return false;
            if (Math.abs(i - index) == Math.abs(sol[i] - col)) return false;
        }
        return true;
    }
}