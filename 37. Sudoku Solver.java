public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int index) {
        if (index == 81) return true;
        int i = index / 9, j = index - i * 9;
        if (board[i][j] != '.') return solveSudokuHelper(board, index + 1);

        for (int val = 1; val <= 9; val++) {
            if (isVallid(board, i, j, val)) {
                board[i][j] = Character.forDigit(val, 10);
                if (solveSudokuHelper(board, index + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isVallid(char[][] board, int i, int j, int val) {
        for (int index = 0; index < 9; index++) {
            if (board[i][index] == Character.forDigit(val, 10)) return false;
            if (board[index][j] == Character.forDigit(val, 10)) return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++)
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++)
                if (board[row][col] == Character.forDigit(val, 10)) return false;
        return true;
    }
}