class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] sol = new int[n];
        solveNQueensHelper(0, n, sol, res);
        return res;
    }

    private void solveNQueensHelper(int index, int n, int[] sol, List<List<String>> res) {
        if (index == n) {
            res.add(PrintSolution(sol));
            return;
        }

        for (int i = 0; i < n; i++)
            if (canFitAt(index, i, sol)) {
                sol[index] = i;
                solveNQueensHelper(index + 1, n, sol, res);
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

    private List<String> PrintSolution(int[] sol) {
        List<String> printSol = new ArrayList<>();
        for (int i = 0; i < sol.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sol.length; j++) {
                if (j == sol[i]) sb.append('Q');
                else sb.append('.');
            }
            printSol.add(sb.toString());
        }
        return printSol;
    }
}