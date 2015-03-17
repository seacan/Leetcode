public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9], row = new int[9], section = new int[9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.'){
                    int val = board[i][j] - '0';
                    if ((row[i] >> val & 1) == 1) return false;
                    else row[i] |= 1 << val;
                    if ((col[j] >> val & 1) == 1) return false;
                    else col[j] |= 1 << val;
                    // locate section index by the factor of 3
                    int index = i / 3 * 3 + j / 3;
                    if ((section[index] >> val & 1) == 1) return false;
                    else section[index] |= 1 << val;
                }
        return true;
    }
}